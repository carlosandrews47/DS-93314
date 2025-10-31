import { useState } from 'react'
import './style.css'

export default function Aluno() {
    // Criando estados para os dados do aluno
    const [nome, setNome] = useState("João Silva")
    const [email, setEmail] = useState("joao.silva@email.com")
    const [cpf, setCpf] = useState("123.456.789-00")
    
    return (
        <div className='aluno'>
            <h2>Dados do Aluno</h2>
            <p><strong>Nome: </strong> {nome}</p>
            <p><strong>Email: </strong> {email}</p>
            <p><strong>CPF: </strong> {cpf}</p>
        </div>
    )
}