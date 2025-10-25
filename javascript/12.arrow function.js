// 12. arrow_function.js
// Arrow Functions

const somar = (a, b) => {
    return a + b;
}

const subtrair = (a, b) => a - b;

const multiplicar = (a, b) => a * b;

const dividir = (a, b) => a / b;

// Usando as arrow functions
const soma = somar(2, 3);
const subtracao = subtrair(5, 2);
const multiplicacao = multiplicar(4, 3);
const divisao = dividir(10, 2);

console.log(`Soma: ${soma}`);
console.log(`Subtração: ${subtracao}`);
console.log(`Multiplicação: ${multiplicacao}`);
console.log(`Divisão: ${divisao}`);