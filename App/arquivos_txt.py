# arquivos_txt.py
# Leitura e escrita dos arquivos TXT usados pelo sistema

import os

DATA_PATH = "data"

def ler_arquivo(nome_arquivo):
    caminho = os.path.join(DATA_PATH, nome_arquivo)
    if not os.path.exists(caminho):
        return []

    dados = []
    with open(caminho, "r", encoding="utf-8") as arquivo:
        for linha in arquivo:
            linha = linha.strip()
            if linha:
                dados.append(linha.split(";"))
    return dados


def escrever_arquivo(nome_arquivo, lista_de_listas):
    caminho = os.path.join(DATA_PATH, nome_arquivo)

    with open(caminho, "w", encoding="utf-8") as arquivo:
        for item in lista_de_listas:
            linha = ";".join(map(str, item))
            arquivo.write(linha + "\n")


def adicionar_linha(nome_arquivo, lista_campos):
    caminho = os.path.join(DATA_PATH, nome_arquivo)

    with open(caminho, "a", encoding="utf-8") as arquivo:
        linha = ";".join(map(str, lista_campos))
        arquivo.write(linha + "\n")
