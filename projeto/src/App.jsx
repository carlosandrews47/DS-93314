
import './App.css'
import AdicionarAluno from './componentes/AdcionarAluno'
import Footer from './componentes/Footer'
import Header from './componentes/Header'

function App() {
  
  return (
    <>
    <Header/>
      <h1>Sistema Escolar</h1>
      <div>
        <AdicionarAluno/>
      </div>
      <Footer/>
    </>
  )
}

export default App
