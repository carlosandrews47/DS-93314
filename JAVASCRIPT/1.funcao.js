// 1.funcao.js

// Função tradicional
function somar(a, b) {
    return a + b
}

// Arrow function corrigida
const subtrair = (a, b) => a - b

const soma = somar(2, 3)
const subtracao = subtrair(2, 3)

console.log(`Soma: ${soma}`)
console.log(`Subtracao: ${subtracao}`)