from arquivos_txt import ler_arquivo, escrever_arquivo, adicionar_linha


class Controller:

    # =============================
    # CLIENTES
    # =============================
    def listar_clientes(self):
        return ler_arquivo("clientes.txt")

    def adicionar_cliente(self, nome, telefone, endereco):
        novo = [nome, telefone, endereco]
        adicionar_linha("clientes.txt", novo)

    # =============================
    # MOTORISTAS
    # =============================
    def listar_motoristas(self):
        return ler_arquivo("motoristas.txt")

    def adicionar_motorista(self, nome, cnh, telefone):
        novo = [nome, cnh, telefone]
        adicionar_linha("motoristas.txt", novo)

    # =============================
    # CARGAS
    # =============================
    def listar_cargas(self):
        return ler_arquivo("cargas.txt")

    def adicionar_carga(self, descricao, peso, destino):
        nova = [descricao, peso, destino]
        adicionar_linha("cargas.txt", nova)

    # =============================
    # RELATÓRIOS
    # =============================
    def listar_relatorios(self):
        return ler_arquivo("relatorios.txt")

    def adicionar_relatorio(self, titulo, data, resumo):
        novo = [titulo, data, resumo]
        adicionar_linha("relatorios.txt", novo)
