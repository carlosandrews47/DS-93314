import { useState, useEffect } from 'react';
import { toast } from 'react-toastify';
import api from '../services/api';
import './style.css';

export default function ListarFuncionarioPage() {
    const [funcionarios, setFuncionarios] = useState([]);
    const [carregando, setCarregando] = useState(true);

    useEffect(() => {
        async function buscarFuncionarios() {
            try {
                const resposta = await api.get('/usuarios');
                setFuncionarios(resposta.data);
            } catch (error) {
                console.error('Erro ao buscar funcionários:', error);
                const mensagemDoServidor = error.response?.data?.mensagem || 'Erro ao carregar a lista de funcionários. Tente novamente mais tarde.';
                toast.error(mensagemDoServidor);
            } finally {
                setCarregando(false);
            }
        }

        buscarFuncionarios();
    }, []);

    const handleExcluirFuncionario = async (id, nome) => {
        if (!window.confirm(`Tem certeza que deseja excluir o funcionário ${nome}?`)) {
            return;
        }

        try {
            await api.delete(`/usuarios/${id}`);
            toast.success('Funcionário excluído com sucesso!');
            // Atualizar a lista após exclusão
            setFuncionarios(funcionarios.filter(func => func.id !== id));
        } catch (error) {
            console.error('Erro ao excluir funcionário:', error);
            const mensagemDoServidor = error.response?.data?.mensagem || 'Erro ao excluir funcionário. Tente novamente.';
            toast.error(mensagemDoServidor);
        }
    };

    if (carregando) {
        return (
            <div className="listar-container">
                <div className="loading">
                    <p>Carregando funcionários...</p>
                </div>
            </div>
        );
    }

    return (
        <div className="listar-container">
            <h1>Lista de Funcionários</h1>
            
            {funcionarios.length === 0 ? (
                <div className="sem-funcionarios">
                    <p>Nenhum funcionário cadastrado.</p>
                </div>
            ) : (
                <div className="tabela-container">
                    <table className="tabela-funcionarios">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nome</th>
                                <th>Email</th>
                                <th>Data de Cadastro</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            {funcionarios.map((funcionario) => (
                                <tr key={funcionario.id}>
                                    <td>{funcionario.id}</td>
                                    <td>{funcionario.nome || funcionario.name}</td>
                                    <td>{funcionario.email}</td>
                                    <td>
                                        {funcionario.dataCadastro ? 
                                            new Date(funcionario.dataCadastro).toLocaleDateString('pt-BR') : 
                                            'N/A'
                                        }
                                    </td>
                                    <td>
                                        <button 
                                            className="btn-excluir"
                                            onClick={() => handleExcluirFuncionario(
                                                funcionario.id, 
                                                funcionario.nome || funcionario.name
                                            )}
                                            title="Excluir funcionário"
                                        >
                                            Excluir
                                        </button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            )}

            <div className="acoes-container">
                <button 
                    className="btn-atualizar"
                    onClick={() => window.location.reload()}
                    disabled={carregando}
                >
                    {carregando ? 'Atualizando...' : 'Atualizar Lista'}
                </button>
                
                <button 
                    className="btn-voltar"
                    onClick={() => window.history.back()}
                >
                    Voltar
                </button>
            </div>
        </div>
    );
}