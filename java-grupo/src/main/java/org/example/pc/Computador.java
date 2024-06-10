package org.example.pc;

import org.example.pc.componentes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Computador {
    private Integer idMaquina;
    private String hostname;
    private Boolean ativo;
    private Integer empresa;
    private List<Componente> listaComponentes;
    private RedeCp rede;
    private DiscoCp disco;
    private ProcessadorCp processador;
    private RamCp ram;
    private VolumeCp volume;
    private SistemaCp sistema;

    public Computador(Integer idMaquina, String hostname, Boolean ativo, Integer empresa) {
        this.idMaquina = idMaquina;
        this.hostname = hostname;
        this.ativo = ativo;
        this.empresa = empresa;
        this.listaComponentes =  new ArrayList<>();
        this.disco       = new DiscoCp(idMaquina);
        this.rede        = new RedeCp(idMaquina);
        this.processador = new ProcessadorCp(idMaquina);
        this.ram         = new RamCp(idMaquina);
        this.volume      = new VolumeCp(idMaquina);
        this.sistema     = new SistemaCp(idMaquina);
        listaComponentes.add(ram);
        listaComponentes.add(disco);
        listaComponentes.add(processador);
        listaComponentes.add(rede);
        listaComponentes.add(sistema);
        listaComponentes.add(volume);

    }


    public Integer getIdMaquina() {
        return idMaquina;
    }

    public String getHostname() {
        return hostname;
    }

    public Integer getEmpresa() {
        return empresa;
    }

    public RedeCp getRede() {
        return rede;
    }

    public DiscoCp getDisco() {
        return disco;
    }

    public ProcessadorCp getProcessador() {
        return processador;
    }

    public RamCp getRam() {
        return ram;
    }

    public VolumeCp getVolume() {
        return volume;
    }

    public SistemaCp getSistema() {
        return sistema;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Componente> getListaComponentes() {
        return listaComponentes;
    }

    public void setListaComponentes(List<Componente> listaComponentes) {
        this.listaComponentes = listaComponentes;
    }

    public void buscarInfos(Integer primeiro) {
        if (primeiro == 0) {
            for (Componente componenteAtual : listaComponentes) {
                System.out.println(componenteAtual);
                componenteAtual.buscarInfosFixos();
            }
        }

        try {
            TimeUnit.SECONDS.sleep(10);
//            System.out.println("asldnaoçsndfçlasndopansdlkjahs dklahsb d");

            System.out.println("""
                    pegando dados em tempo real
                    ...............................""");
            for (Componente componenteAtual : listaComponentes) {
                System.out.println(componenteAtual);
                componenteAtual.buscarInfosVariaveis();
            }
            buscarInfos(1);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return "Computador{" +
                "idMaquina=" + idMaquina +
                ", hostname='" + hostname + '\'' +
                ", ativo=" + ativo +
                ", empresa=" + empresa +
                ", listaComponentes=" + listaComponentes +
                ", rede=" + rede +
                ", disco=" + disco +
                ", processador=" + processador +
                ", ram=" + ram +
                ", volume=" + volume +
                ", sistema=" + sistema +
                '}';
    }
}
