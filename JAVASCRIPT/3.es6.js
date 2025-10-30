// Array de usuários exemplo
const usuarios = [
    { nome: 'João', idade: 25 },
    { nome: 'Maria', idade: 17 },
    { nome: 'Pedro', idade: 16 },
    { nome: 'Ana', idade: 22 },
    { nome: 'Marta', idade: 30 },
    { nome: 'Carlos', idade: 15 }
];

// ========== PRIMEIRA PARTE (forEach, filter, map) ==========
console.log('Percorrendo vetor: ');
usuarios.forEach((u) =>
    console.log(`Nome: ${u.nome} tem ${u.idade} anos.`));

console.log('\nFiltrando por idade menor que 18 anos: ');
const menorIdade = usuarios.filter((u) => u.idade < 18);
menorIdade.forEach((u) =>
    console.log(`Nome: ${u.nome} tem ${u.idade} anos.`));

console.log('\nRetornando apenas nomes da lista: ');
const listaDeNomes = usuarios.map(u => u.nome);
listaDeNomes.forEach((nome, index) =>
    console.log(`${index + 1} - nome: ${nome}`));

// ========== SEGUNDA PARTE (find, reduce) ==========
console.log('\nExibindo primeiro usuário: ');
console.log(`Nome: ${usuarios[0].nome} tem ${usuarios[0].idade} anos.`);

console.log('\nRetornando apenas nomes da lista: ');
const listaDeNomes2 = usuarios.map(u => u.nome);
listaDeNomes2.forEach((nome, index) =>
    console.log(`${index + 1} - nome: ${nome}`));

console.log('\nEncontrar usuário na lista: ');
const usuarioEncontrado = usuarios.find(u => u.nome === 'Marta');
console.log(usuarioEncontrado);
if (usuarioEncontrado) {
    console.log(`Nome: ${usuarioEncontrado.nome}, idade: ${usuarioEncontrado.idade}`);
} else {
    console.log('Usuário não encontrado');
}

console.log('\nSomando todas as idades da lista: ');
const somaIdades = usuarios.reduce((soma, u) => soma + u.idade, 0);
console.log(`Soma: ${somaIdades}`);

// ========== EXTRA: Estatísticas completas ==========
console.log('\n=== ESTATÍSTICAS COMPLETAS ===');
console.log(`Total de usuários: ${usuarios.length}`);
console.log(`Média de idade: ${(somaIdades / usuarios.length).toFixed(1)} anos`);

const adultos = usuarios.filter(u => u.idade >= 18);
const menores = usuarios.filter(u => u.idade < 18);

console.log(`Adultos (≥18 anos): ${adultos.length}`);
console.log(`Menores de idade: ${menores.length}`);

// Usuário mais velho
const usuarioMaisVelho = usuarios.reduce((maisVelho, atual) => 
    atual.idade > maisVelho.idade ? atual : maisVelho
);
console.log(`Usuário mais velho: ${usuarioMaisVelho.nome} (${usuarioMaisVelho.idade} anos)`);