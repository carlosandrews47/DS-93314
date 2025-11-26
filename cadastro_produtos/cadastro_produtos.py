import customtkinter as ctk
from tkinter import messagebox, ttk

class CadastroProdutos:
    def __init__(self):
        # Configurar a aparência da aplicação
        ctk.set_appearance_mode("dark")  # Modo escuro
        ctk.set_default_color_theme("blue")  # Tema de cores azul
        
        # Criar janela principal
        self.janela = ctk.CTk()
        self.janela.title("Sistema de Cadastro de Produtos")
        self.janela.geometry("600x700")
        self.janela.resizable(True, True)
        
        # Lista para armazenar os produtos (em vez do banco de dados)
        self.produtos = []
        
        # Criar a interface gráfica
        self.criar_interface()
    
    def criar_interface(self):
        """Criar todos os elementos da interface gráfica"""
        
        # Título principal
        titulo = ctk.CTkLabel(
            self.janela, 
            text="CADASTRO DE PRODUTOS",
            font=("Arial", 20, "bold")
        )
        titulo.pack(pady=20)
        
        # Frame principal para os campos de entrada
        frame_campos = ctk.CTkFrame(self.janela)
        frame_campos.pack(pady=10, padx=20, fill="both")
        
        # CAMPO CÓDIGO
        lbl_codigo = ctk.CTkLabel(frame_campos, text="Código:", font=("Arial", 14))
        lbl_codigo.grid(row=0, column=0, padx=10, pady=10, sticky="w")
        self.entry_codigo = ctk.CTkEntry(frame_campos, width=300, font=("Arial", 14))
        self.entry_codigo.grid(row=0, column=1, padx=10, pady=10, sticky="ew")
        
        # CAMPO DESCRIÇÃO
        lbl_descricao = ctk.CTkLabel(frame_campos, text="Descrição:", font=("Arial", 14))
        lbl_descricao.grid(row=1, column=0, padx=10, pady=10, sticky="w")
        self.entry_descricao = ctk.CTkEntry(frame_campos, width=300, font=("Arial", 14))
        self.entry_descricao.grid(row=1, column=1, padx=10, pady=10, sticky="ew")
        
        # CAMPO FABRICANTE
        lbl_fabricante = ctk.CTkLabel(frame_campos, text="Fabricante:", font=("Arial", 14))
        lbl_fabricante.grid(row=2, column=0, padx=10, pady=10, sticky="w")
        self.entry_fabricante = ctk.CTkEntry(frame_campos, width=300, font=("Arial", 14))
        self.entry_fabricante.grid(row=2, column=1, padx=10, pady=10, sticky="ew")
        
        # CAMPO PREÇO UNITÁRIO
        lbl_preco = ctk.CTkLabel(frame_campos, text="Preço Unitário R$:", font=("Arial", 14))
        lbl_preco.grid(row=3, column=0, padx=10, pady=10, sticky="w")
        self.entry_preco = ctk.CTkEntry(frame_campos, width=300, font=("Arial", 14))
        self.entry_preco.grid(row=3, column=1, padx=10, pady=10, sticky="ew")
        
        # CAMPO QUANTIDADE
        lbl_quantidade = ctk.CTkLabel(frame_campos, text="Quantidade:", font=("Arial", 14))
        lbl_quantidade.grid(row=4, column=0, padx=10, pady=10, sticky="w")
        self.entry_quantidade = ctk.CTkEntry(frame_campos, width=300, font=("Arial", 14))
        self.entry_quantidade.grid(row=4, column=1, padx=10, pady=10, sticky="ew")
        
        # CAMPO PREÇO TOTAL (somente leitura)
        lbl_preco_total = ctk.CTkLabel(frame_campos, text="Preço Total R$:", font=("Arial", 14))
        lbl_preco_total.grid(row=5, column=0, padx=10, pady=10, sticky="w")
        self.entry_preco_total = ctk.CTkEntry(
            frame_campos, 
            width=300, 
            font=("Arial", 14),
            state="readonly"  # Campo somente leitura
        )
        self.entry_preco_total.grid(row=5, column=1, padx=10, pady=10, sticky="ew")
        
        # Configurar para que a coluna 1 expanda
        frame_campos.columnconfigure(1, weight=1)
        
        # FRAME PARA OS BOTÕES
        frame_botoes = ctk.CTkFrame(self.janela)
        frame_botoes.pack(pady=20, padx=20, fill="x")
        
        # LISTA DE BOTÕES COM SUAS PROPRIEDADES
        botoes = [
            ("Inserir", self.inserir_produto, "#28a745"),  # Verde
            ("Buscar", self.buscar_produto, "#17a2b8"),    # Azul
            ("Atualizar", self.atualizar_produto, "#ffc107"), # Amarelo
            ("Excluir", self.excluir_produto, "#dc3545"),  # Vermelho
            ("Novo", self.novo_produto, "#6c757d")         # Cinza
        ]
        
        # Criar botões dinamicamente
        for i, (texto, comando, cor) in enumerate(botoes):
            btn = ctk.CTkButton(
                frame_botoes, 
                text=texto, 
                command=comando,
                font=("Arial", 14),
                fg_color=cor
            )
            btn.grid(row=0, column=i, padx=5, pady=10, sticky="ew")
            # Configurar cada coluna de botões com peso igual
            frame_botoes.columnconfigure(i, weight=1)
        
        # FRAME PARA A LISTA DE PRODUTOS
        frame_lista = ctk.CTkFrame(self.janela)
        frame_lista.pack(pady=10, padx=20, fill="both", expand=True)
        
        # TABELA PARA MOSTRAR OS PRODUTOS (Treeview)
        colunas = ("Código", "Descrição", "Fabricante", "Preço Unitário", "Quantidade", "Preço Total")
        self.treeview = ttk.Treeview(
            frame_lista, 
            columns=colunas, 
            show="headings",  # Mostrar apenas os cabeçalhos
            height=12
        )
        
        # Configurar os cabeçalhos da tabela
        for col in colunas:
            self.treeview.heading(col, text=col)
            self.treeview.column(col, width=100)
        
        # Barra de rolagem para a tabela
        scrollbar = ttk.Scrollbar(frame_lista, orient="vertical", command=self.treeview.yview)
        self.treeview.configure(yscrollcommand=scrollbar.set)
        
        # Empacotar a tabela e barra de rolagem
        self.treeview.pack(side="left", fill="both", expand=True)
        scrollbar.pack(side="right", fill="y")
        
        # Vincular duplo clique na tabela para selecionar produto
        self.treeview.bind("<Double-1>", self.selecionar_produto)
        
        # Vincular eventos para calcular preço automaticamente
        self.entry_preco.bind("<KeyRelease>", self.calcular_preco_total)
        self.entry_quantidade.bind("<KeyRelease>", self.calcular_preco_total)
    
    def calcular_preco_total(self, event=None):
        """Calcular o preço total automaticamente"""
        try:
            # Tentar converter os valores para números
            preco_unitario = float(self.entry_preco.get() or 0)
            quantidade = int(self.entry_quantidade.get() or 0)
            
            # Calcular preço total
            preco_total = preco_unitario * quantidade
            
            # Atualizar o campo de preço total
            self.entry_preco_total.configure(state="normal")
            self.entry_preco_total.delete(0, 'end')
            self.entry_preco_total.insert(0, f"{preco_total:.2f}")
            self.entry_preco_total.configure(state="readonly")
            
        except ValueError:
            # Se houver erro na conversão, mostrar zero
            self.entry_preco_total.configure(state="normal")
            self.entry_preco_total.delete(0, 'end')
            self.entry_preco_total.insert(0, "0.00")
            self.entry_preco_total.configure(state="readonly")
    
    def inserir_produto(self):
        """Inserir um novo produto na lista"""
        # Obter valores dos campos
        codigo = self.entry_codigo.get().strip()
        descricao = self.entry_descricao.get().strip()
        fabricante = self.entry_fabricante.get().strip()
        
        # Validar campos obrigatórios
        if not all([codigo, descricao, fabricante]):
            messagebox.showerror("Erro", "Código, Descrição e Fabricante são obrigatórios!")
            return
        
        # Validar e converter valores numéricos
        try:
            preco_unitario = float(self.entry_preco.get() or 0)
            quantidade = int(self.entry_quantidade.get() or 0)
            preco_total = preco_unitario * quantidade
        except ValueError:
            messagebox.showerror("Erro", "Preço e Quantidade devem ser números válidos!")
            return
        
        # Verificar se código já existe
        for produto in self.produtos:
            if produto[0] == codigo:
                messagebox.showerror("Erro", "Código do produto já existe!")
                return
        
        # Adicionar produto à lista
        novo_produto = (codigo, descricao, fabricante, preco_unitario, quantidade, preco_total)
        self.produtos.append(novo_produto)
        
        messagebox.showinfo("Sucesso", "Produto inserido com sucesso!")
        self.novo_produto()
        self.carregar_produtos()
    
    def buscar_produto(self):
        """Buscar um produto pelo código"""
        codigo = self.entry_codigo.get().strip()
        
        if not codigo:
            messagebox.showwarning("Aviso", "Digite um código para buscar!")
            return
        
        # Procurar produto na lista
        for produto in self.produtos:
            if produto[0] == codigo:
                self.preencher_campos(produto)
                return
        
        messagebox.showinfo("Busca", "Produto não encontrado!")
    
    def preencher_campos(self, produto):
        """Preencher os campos com os dados do produto"""
        # Limpar campos
        self.entry_codigo.delete(0, 'end')
        self.entry_descricao.delete(0, 'end')
        self.entry_fabricante.delete(0, 'end')
        self.entry_preco.delete(0, 'end')
        self.entry_quantidade.delete(0, 'end')
        
        # Preencher com dados do produto
        self.entry_codigo.insert(0, produto[0])
        self.entry_descricao.insert(0, produto[1])
        self.entry_fabricante.insert(0, produto[2])
        self.entry_preco.insert(0, str(produto[3]))
        self.entry_quantidade.insert(0, str(produto[4]))
        
        # Atualizar preço total
        self.calcular_preco_total()
    
    def atualizar_produto(self):
        """Atualizar um produto existente"""
        codigo = self.entry_codigo.get().strip()
        descricao = self.entry_descricao.get().strip()
        fabricante = self.entry_fabricante.get().strip()
        
        # Validar campos obrigatórios
        if not all([codigo, descricao, fabricante]):
            messagebox.showerror("Erro", "Código, Descrição e Fabricante são obrigatórios!")
            return
        
        # Validar e converter valores numéricos
        try:
            preco_unitario = float(self.entry_preco.get() or 0)
            quantidade = int(self.entry_quantidade.get() or 0)
            preco_total = preco_unitario * quantidade
        except ValueError:
            messagebox.showerror("Erro", "Preço e Quantidade devem ser números válidos!")
            return
        
        # Procurar e atualizar produto
        for i, produto in enumerate(self.produtos):
            if produto[0] == codigo:
                # Atualizar produto na lista
                self.produtos[i] = (codigo, descricao, fabricante, preco_unitario, quantidade, preco_total)
                messagebox.showinfo("Sucesso", "Produto atualizado com sucesso!")
                self.novo_produto()
                self.carregar_produtos()
                return
        
        messagebox.showerror("Erro", "Produto não encontrado!")
    
    def excluir_produto(self):
        """Excluir um produto"""
        codigo = self.entry_codigo.get().strip()
        
        if not codigo:
            messagebox.showwarning("Aviso", "Digite um código para excluir!")
            return
        
        # Confirmar exclusão
        resposta = messagebox.askyesno("Confirmação", f"Excluir produto {codigo}?")
        
        if resposta:
            # Procurar e remover produto
            for i, produto in enumerate(self.produtos):
                if produto[0] == codigo:
                    del self.produtos[i]
                    messagebox.showinfo("Sucesso", "Produto excluído com sucesso!")
                    self.novo_produto()
                    self.carregar_produtos()
                    return
            
            messagebox.showerror("Erro", "Produto não encontrado!")
    
    def novo_produto(self):
        """Limpar os campos para um novo cadastro"""
        self.entry_codigo.delete(0, 'end')
        self.entry_descricao.delete(0, 'end')
        self.entry_fabricante.delete(0, 'end')
        self.entry_preco.delete(0, 'end')
        self.entry_quantidade.delete(0, 'end')
        
        # Limpar e configurar campo de preço total como somente leitura
        self.entry_preco_total.configure(state="normal")
        self.entry_preco_total.delete(0, 'end')
        self.entry_preco_total.configure(state="readonly")
        
        # Colocar foco no campo código
        self.entry_codigo.focus()
    
    def carregar_produtos(self):
        """Carregar todos os produtos na tabela"""
        # Limpar tabela
        for item in self.treeview.get_children():
            self.treeview.delete(item)
        
        # Adicionar cada produto na tabela
        for produto in self.produtos:
            self.treeview.insert('', 'end', values=produto)
    
    def selecionar_produto(self, event):
        """Selecionar produto da tabela para edição"""
        item_selecionado = self.treeview.selection()
        
        if item_selecionado:
            # Obter dados do item selecionado
            item = self.treeview.item(item_selecionado[0])
            valores = item['values']
            
            # Preencher campos com os dados
            self.preencher_campos(valores)
    
    def executar(self):
        """Executar a aplicação"""
        self.janela.mainloop()

# Executar a aplicação
if __name__ == "__main__":
    app = CadastroProdutos()
    app.executar()