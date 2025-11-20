import './style.css';
import * as yup from 'yup';
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import { toast } from 'react-toastify';
import api from '../services/api';

const esquemaDeCadastro = yup.object({
    nome: yup
        .string()
        .required('O nome é obrigatório')
        .min(3, 'O nome deve ter pelo menos 3 caracteres'),
    email: yup
        .string()
        .email('Email inválido')
        .required('O email é obrigatório'),
    senha: yup
        .string()
        .min(6, 'A senha deve ter pelo menos 6 caracteres')
        .required('A senha é obrigatória')
});

export default function CadastroPage() {
    const {
        register: registrarCampo,
        handleSubmit: lidarComEnvioDoFormulario,
        formState: { errors: errosDoFormulario, isSubmitting: estaEnviando },
        reset: limparCamposDoFormulario,
    } = useForm({
        resolver: yupResolver(esquemaDeCadastro),
        defaultValues: {
            nome: '',
            email: '',
            senha: '',
        },
    });

    const enviarDados = async (dadosDoFormulario) => {
        const dadosParaEnvio = {
            name: dadosDoFormulario.nome,
            email: dadosDoFormulario.email,
            password: dadosDoFormulario.senha,
        };
    
        try {
            const resposta = await api.post('/users', dadosParaEnvio);
            toast.success('Funcionário cadastrado com sucesso!');
            limparCamposDoFormulario();
        } catch (error) {
            console.error('Erro ao cadastrar funcionário:', error);
            
            if (error.response?.status === 400) {
                toast.error('Dados inválidos');
            } else if (error.response?.status === 409) {
                toast.error('Email já cadastrado');
            } else {
                toast.error('Erro ao cadastrar funcionário');
            }
        }
    };

      
     
    return (
        <div className='cadastro-container'>
            <h1>Cadastro de Funcionários</h1>
            <form noValidate onSubmit={lidarComEnvioDoFormulario(enviarDados)} className="cadastro-form">
                
                {/* Campo Nome */}
                <div className='form-group'>
                    <label htmlFor='campo-nome'>Nome: </label>
                    <input
                        type='text'
                        id='campo-nome'
                        placeholder='Ex.: João Silva'
                        {...registrarCampo('nome')}
                        className={errosDoFormulario.nome ? 'error' : ''}
                    />
                    {errosDoFormulario.nome && (
                        <span className='error-message'>{errosDoFormulario.nome.message}</span>
                    )}
                </div>

                {/* Campo Email */}
                <div className='form-group'>
                    <label htmlFor='campo-email'>Email: </label>
                    <input
                        type='email'
                        id='campo-email'
                        placeholder='Ex.: joao@empresa.com'
                        {...registrarCampo('email')}
                        className={errosDoFormulario.email ? 'error' : ''}
                    />
                    {errosDoFormulario.email && (
                        <span className='error-message'>{errosDoFormulario.email.message}</span>
                    )}
                </div>

                {/* Campo Senha */}
                <div className='form-group'>
                    <label htmlFor='campo-senha'>Senha: </label>
                    <input
                        type='password'
                        id='campo-senha'
                        placeholder='Mínimo 6 caracteres'
                        {...registrarCampo('senha')}
                        className={errosDoFormulario.senha ? 'error' : ''}
                    />
                    {errosDoFormulario.senha && (
                        <span className='error-message'>{errosDoFormulario.senha.message}</span>
                    )}
                </div>

                <button 
                    type='submit' 
                    disabled={estaEnviando}
                    className="submit-btn"
                >
                    {estaEnviando ? 'Cadastrando...' : 'Cadastrar Funcionário'}
                </button>
            </form>
        </div>
    );
}