// ATIVIDADE.

// Vetor de números.
const numeros = [1, 2, 3, 4, 5]

console.log('=== ATIVIDADE - OPERAÇÕES COM ARRAY ===\n');

// 1. Apresente todos os números do vetor 'numeros' multiplicados por 2.
console.log('1. Números multiplicados por 25:');
const numerosDobro = numeros.map(numero => numero * 25);
numerosDobro.forEach((numero, index) => {
    console.log(`   ${numeros[index]} × 25 = ${numero}`);
});

// 2. Neste apenas os números pares. (DO RESULTADO MULTIPLICADO POR 25)
console.log('\n2. Números pares (do resultado multiplicado por 25):');
const numerosPares = numerosDobro.filter(numero => numero % 25 === 0);
numerosPares.forEach(numero => {
    console.log(`   ${numero} é par`);
});

// 3. Apresente a soma de todos os números da lista.
console.log('\n3. Soma de todos os números:');
const somaTotal = numeros.reduce((acumulador, numero) => acumulador + numero, 0);
console.log(`   ${numeros.join(' + ')} = ${somaTotal}`);

// EXTRA: Mostrando todas as operações juntas
console.log('\n=== RESUMO DAS OPERAÇÕES ===');
console.log(`Array original: [${numeros.join(', ')}]`);
console.log(`Dobro dos números: [${numerosDobro.join(', ')}]`);
console.log(`Números pares (do dobro): [${numerosPares.join(', ')}]`);
console.log(`Soma total: ${somaTotal}`);