import tkinter as tk
from tkinter import ttk
from controller import Controller

controller = Controller()

# ============================
# JANELA PRINCIPAL
# ============================
def iniciar_interface():
    root = tk.Tk()
    root.title("Sistema da Transportadora")
    root.geometry("600x400")

    titulo = ttk.Label(root, text="Sistema da Transportadora", font=("Arial", 18))
    titulo.pack(pady=20)

    # ---- Botões principais ----
    ttk.Button(root, text="Clientes", width=30,
               command=abrir_clientes).pack(pady=5)

    ttk.Button(root, text="Motoristas", width=30,
               command=abrir_motoristas).pack(pady=5)

    ttk.Button(root, text="Cargas", width=30,
               command=abrir_cargas).pack(pady=5)

    ttk.Button(root, text="Relatórios", width=30,
               command=abrir_relatorios).pack(pady=5)

    ttk.Button(root, text="Sair", width=30,
               command=root.destroy).pack(pady=30)

    root.mainloop()


# ============================
# TELAS SIMPLES (serão melhoradas depois)
# ============================
def abrir_clientes():
    janela = tk.Toplevel()
    janela.title("Gerenciar Clientes")
    janela.geometry("400x300")
    ttk.Label(janela, text="Tela de Clientes", font=("Arial", 14)).pack(pady=20)


def abrir_motoristas():
    janela = tk.Toplevel()
    janela.title("Gerenciar Motoristas")
    janela.geometry("400x300")
    ttk.Label(janela, text="Tela de Motoristas", font=("Arial", 14)).pack(pady=20)


def abrir_cargas():
    janela = tk.Toplevel()
    janela.title("Gerenciar Cargas")
    janela.geometry("400x300")
    ttk.Label(janela, text="Tela de Cargas", font=("Arial", 14)).pack(pady=20)


def abrir_relatorios():
    janela = tk.Toplevel()
    janela.title("Relatórios")
    janela.geometry("400x300")
    ttk.Label(janela, text="Tela de Relatórios", font=("Arial", 14)).pack(pady=20)
