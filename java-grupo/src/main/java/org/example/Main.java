package org.example;

import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.Volume;
import com.sun.jna.platform.win32.WinDef;
import org.example.pc.componentes.DiscoCp;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.hardware.NetworkIF;
import com.github.britooo.looca.api.core.Looca;

import java.util.Dictionary;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
//    Computador com = new Computador();
//
//    com.teste();
//        Looca looca = new Looca();
//        List<Volume> teste = looca.getGrupoDeDiscos().getVolumes();
//        Integer qtdVolumesVolume = looca.getGrupoDeDiscos().getQuantidadeDeVolumes();
//        System.out.println(qtdVolumesVolume - 1);
//
//        for (int i = 1; i < qtdVolumesVolume; i++) {
//
//            //            VOLUME
//            String UUIDVolume = teste.get(i).getUUID();
//            String nomeVolume = teste.get(i).getNome();
//            Long totalVolume = teste.get(i).getTotal();
//            Long disponivelVolume = teste.get(i).getDisponivel();
//            String tipoVolume = teste.get(i).getTipo();
//
//            System.out.println(nomeVolume);
//        }
//


//        Conexao conexao = new Conexao();
//        JdbcTemplate con = conexao.getConexaoDoBanco();

        Scanner input = new Scanner(System.in);
        Scanner inputText = new Scanner(System.in);

        System.out.println("""
                    ----------------------------------------
                    |                                      |
                    |           Digite o seu email:        |
                    |                                      |
                    ----------------------------------------""");

        String emailLogin = inputText.nextLine();


        System.out.println("""
                    ----------------------------------------
                    |                                      |
                    |           Digite a sua senha:        |
                    |                                      |
                    ----------------------------------------""");
        String senhaLogin = inputText.nextLine();

        System.out.println("""
                    ----------------------------------------
                    |                                      |
                    |        Confirmar a sua senha:        |
                    |                                      |
                    ----------------------------------------""");
        String confirmarSenhaLogin = inputText.nextLine();

        Conexao con = new Conexao();
//        Computador computador = new Computador();
        try {
            con.buscarCredenciais(emailLogin, senhaLogin);
            System.out.println("""
                                Usuario Logado com sucesso
                                ..............................""");
            con.computadorExiste(1);
        }catch (Exception erro){
            System.out.println(erro);
            System.out.println("""
                                Erro ao fazer Login, tente novamente
                                .......................................""");
        }
    }
}

//'1', 'recepção', 'Raimunda', 'raimunda@netmet.com', '1234', '1'
