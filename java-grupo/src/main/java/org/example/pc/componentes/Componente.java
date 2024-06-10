package org.example.pc.componentes;

public abstract class Componente {

    protected Integer fkMaquina;

    public Componente(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    public abstract void buscarInfosFixos ();

    abstract public void buscarInfosVariaveis ();

    abstract public void atualizarFixos();
}
