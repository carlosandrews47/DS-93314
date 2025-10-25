// 10. operadores.js
// Operadores de diferença e lógicos

let idade1 = 20;        // number
let idade2 = '20';      // string

console.log('=== DIFERENTE ===');
console.log('=== Comparando conteúdo ===');
console.log(idade1 != idade2);      // false - valores são iguais

console.log('=== Comparando tipo e conteúdo ===');
console.log(idade1 !== idade2);     // true - tipos são diferentes

console.log('=== AND ===');
console.log('=== 1 é menor que 2 e 1 é menor que 3? ===');
console.log(1 < 2 && 1 < 3);        // true - ambas condições são verdadeiras