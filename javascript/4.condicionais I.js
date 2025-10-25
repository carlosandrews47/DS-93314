// 4. condicionais I.js
// Estrutura condicional simples

const idade = 20;

console.log("=== Condicional Simples ===");
console.log("Idade:", idade);

if (idade < 18) {
    console.log("Menor de idade.");
} else {
    console.log("Maior de idade.");
}

// Exemplo com else if
const nota = 7.5;

console.log("--- Exemplo com Nota ---");
console.log("Nota:", nota);

if (nota >= 9) {
    console.log("Excelente!");
} else if (nota >= 7) {
    console.log("Bom!");
} else if (nota >= 5) {
    console.log("Recuperação");
} else {
    console.log("Reprovado");
}