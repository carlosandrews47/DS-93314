import './style.css';
 export default function Footer() {
    const anoAtual = new Date().getFullYear();
    return (
        <>
        <footer className="footer">
         <span>&copy; {anoAtual} -Todos os direitos reservados.</span>
         </footer>
        </>
    );
 }