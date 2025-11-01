import { useState } from 'react';
import './style.css';

export default function AdicionarAluno() {
    // Criando e inicializando as variáveis.
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');

    // Criando uma lista para adicionar os nomes dos alunos.
    const [listaAlunos, setListaAlunos] = useState([]);

    // Função para adicionar dados do aluno na lista de alunos.
    const adicionarAluno = (event) => {
        // Evita que a página seja recarregada ao adicionar aluno.
        event.preventDefault();
        if (nome && email) {
            // Add os dados anteriores + novos dados.
            setListaAlunos([...listaAlunos, { nome, email }]);
            // Define o valor dos campos como vazio novamente.
            setNome('');
            setEmail('');
        }
    };

    // HTML
    return (
        <div>
            <h2>Adicionar Aluno</h2>
            <form onSubmit={adicionarAluno}>
                <input
                    type="text"
                    placeholder="Nome"
                    value={nome}
                    onChange={(e) => setNome(e.target.value)}
                />
                <input
                    type="email"
                    placeholder="E-mail"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />
                <button type='submit'>Adicionar</button>
            </form>
            
            <br />
            <h3>Matriculados</h3>
            <ul>
                {listaAlunos.map((aluno, index) => (
                    <li key={index}>
                        {aluno.nome} - {aluno.email}
                    </li>
                ))}
            </ul>
        </div>
    )
}