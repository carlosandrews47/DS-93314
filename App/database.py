import os

# Caminho da pasta "data"
DATA_DIR = "data"

# Garante que a pasta existe
os.makedirs(DATA_DIR, exist_ok=True)

# Caminhos completos dos arquivos TXT
CLIENTES_FILE = os.path.join(DATA_DIR, "clientes.txt")
MOTORISTAS_FILE = os.path.join(DATA_DIR, "motoristas.txt")
CARGAS_FILE = os.path.join(DATA_DIR, "cargas.txt")
RELATORIOS_FILE = os.path.join(DATA_DIR, "relatorios.txt")

# Função para criar arquivos vazios caso não existam
def inicializar_arquivos():
    arquivos = [
        CLIENTES_FILE,
        MOTORISTAS_FILE,
        CARGAS_FILE,
        RELATORIOS_FILE
    ]

    for arquivo in arquivos:
        if not os.path.exists(arquivo):
            with open(arquivo, "w", encoding="utf-8") as f:
                f.write("")  # cria vazio
