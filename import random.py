import random
import math
import datetime

# FUNÇÕES EM PYTHON

def imprimir():
    print("função sem parâmetro")

# Chamando a função
imprimir()

def somar(a, b):
    return a + b

def multiplicacao(x, y):
    resultado = x * y 
    return resultado

print(somar(5, 2))
print(multiplicacao(4, 3))
print(random.randint(1, 100))
print(math.sqrt(121))  # Corrigido: era "match" em vez de "math"

print(datetime.datetime.now())
agora = datetime.datetime.now()
print("Ano:", agora.year)
print("Mês:", agora.month)
print("Dia:", agora.day)
print("Hora:", agora.hour)
print("Minuto:", agora.minute)
print("Segundo:", agora.second)

# Exemplo adicional com formatação de data
import random
import math
import datetime

# FUNÇÕES EM PYTHON

def imprimir():
    print("função sem parâmetro")

# Chamando a função
imprimir()

def somar(a, b):
    return a + b

def multiplicacao(x, y):
    resultado = x * y 
    return resultado

print(somar(5, 2))
print(multiplicacao(4, 3))
print(random.randint(1, 100))
print(math.sqrt(121))  # Corrigido: era "match" em vez de "math"

print(datetime.datetime.now())
agora = datetime.datetime.now()
print("Ano:", agora.year)
print("Mês:", agora.month)
print("Dia:", agora.day)
print("Hora:", agora.hour)
print("Minuto:", agora.minute)
print("Segundo:", agora.second)

# Exemplo adicional com formatação de data
print("\nData formatada:", agora.strftime("%d/%m/%Y %H:%M:%S")) 

