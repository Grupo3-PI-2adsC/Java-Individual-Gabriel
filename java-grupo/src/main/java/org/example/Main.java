package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LimparVolume limpando = new LimparVolume();
        limpando.iniciarLimpezaVolume();
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
