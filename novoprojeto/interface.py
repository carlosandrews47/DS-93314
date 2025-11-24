from tkinter import *

tela = Tk()
tela.title("Minha primeira janela")
tela.geometry("500x500+500+200")


tela.configure(bg='#FFE4E1')  # Esta é a forma correta!


label1 = Label(tela, text="Carlos Andre!", bg='#FFE4E1')
label1.pack(pady=10)


tela.resizable(False, False)


try:
    tela.iconbitmap("imagens/bol.ico")
    print("Ícone carregado com sucesso!")
except:
    print("Ícone não encontrado. Continuando com ícone padrão.")

tela.mainloop()