import { useState } from 'react'
import './style.css'

export default function InfoCurso() {
    // Criando variáveis
    // useState é uma função do ReactJS
    // Também chamada de Hooks
    const [nome, setNome] = useState("Desenvolvimento de Sistemas")
    const [cargaHoraria, setCargaHoraria] = useState(158)
    
    return (
        <div className='info-curso'>
            <h2>Dados do Curso</h2>
            <p><strong>Nome: </strong> {nome}</p>
            <p><strong>Carga Horária: </strong> {cargaHoraria} horas</p>
            <p><strong>Local: </strong> SENAI</p>
        </div>
    )
}