# CORRETO - range(6) vai de 0 a 5
for i in range(6):
    print("O valor de i é:", i)
print("Fim do laço for")

print("\n" + "="*30)

# CORRETO - range(1,11) vai de 1 a 10
for x in range(1, 11):
    print(x)

print("\n" + "="*30)

# CORRETO - iterando sobre string
for char in "python":
    print(char)

print("\n" + "="*30)

# CORRETO - iterando sobre lista
lista = [10, 20, 30, 40, 50]
for i in lista:
    print(i)

print("\n" + "="*30)

# CORRETO - iterando sobre lista de strings
computador = ['processador', 'memória', 'placa mãe']
for item in computador:
    print(item)

print("\n" + "="*30)

# CORRETO - operações com listas
lista = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]

# Acessando elemento pelo índice
print("Elemento no índice 4:", lista[4])  # 50

# Obtendo tamanho da lista
print("Tamanho da lista:", len(lista))

# Adicionando elementos na lista
lista.append(101)
print("Após append(101):", lista)

# Removendo elemento pelo valor
lista.remove(20)
print("Após remove(20):", lista)

# Removendo elemento pelo índice
lista.pop(8)  # Remove o elemento no índice 8
print("Após pop(8):", lista)

# Removendo elemento pelo índice usando del
del lista[2]  # Remove o elemento no índice 2
print("Após del lista[2]:", lista)

# Removendo todos os elementos da lista
lista.clear()
print("Após clear():", lista)