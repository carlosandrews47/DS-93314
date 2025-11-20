import { Link } from 'react-router-dom';
import './style.css';

export default function Header() {
    
    return (
        <header className="header">
            <Link to="/">SENAI</Link>
            <nav>
                <Link to="/cadastro">Cadastrar Funcionários</Link>
                <Link to="/funcionarios">Listar Funcionários</Link>
            </nav>
        </header>
    );
}