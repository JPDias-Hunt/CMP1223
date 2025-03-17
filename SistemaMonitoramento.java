import java.util.*;

class Paciente {
    protected String nome;
    protected int idade;
    protected String statusSaude;

    public Paciente(String nome, int idade, String statusSaude) {
        this.nome = nome;
        this.idade = idade;
        this.statusSaude = statusSaude;
    }

    public String getNome() { return nome; }
    public String getStatusSaude() { return statusSaude; }
    public int getIdade() { return idade; }
}


class PacienteInternado extends Paciente {
    private ArrayList<DispositivoMedico> dispositivosConectados = new ArrayList<>();

    public PacienteInternado(String nome, int idade, String statusSaude) {
        super(nome, idade, statusSaude);
    }

    public void conectarDispositivo(DispositivoMedico dispositivo) {
        if (dispositivosConectados.size() < 2) {
            dispositivosConectados.add(dispositivo);
            System.out.println("Dispositivo " + dispositivo.getTipo() + " conectado ao paciente " + nome);
        } else {
            System.out.println("Paciente já possui o número máximo de dispositivos conectados.");
        }
    }

    public void monitorar() {
        if (dispositivosConectados.isEmpty()) {
            System.out.println("Nenhum dispositivo conectado ao paciente " + nome);
        } else {
            for (DispositivoMedico dispositivo : dispositivosConectados) {
                String alerta = dispositivo.coletarDados();
                System.out.println("Alerta para " + nome + ": " + alerta);
            }
        }
    }
}


class PacienteAmbulatorial extends Paciente {
    public PacienteAmbulatorial(String nome, int idade, String statusSaude) {
        super(nome, idade, statusSaude);
    }
}

class PacienteEmergencia extends Paciente {
    public PacienteEmergencia(String nome, int idade, String statusSaude) {
        super(nome, idade, statusSaude);
    }

    public void atenderUrgencia() {
        System.out.println("Atendendo urgência do paciente: " + nome);
    }
}

class DispositivoMedico {
    public String coletarDados() {
        return "Dados genéricos do dispositivo.";
    }

    public String getTipo() {
        return "Dispositivo Médico Genérico";
    }
}

class MonitorCardiaco extends DispositivoMedico {
    public String coletarDados() {
        int frequencia = new Random().nextInt(50) + 60;
        if (frequencia < 60 || frequencia > 100) {
            return "Alerta: Frequência cardíaca anormal: " + frequencia + " bpm.";
        }
        return "Frequência cardíaca normal: " + frequencia + " bpm.";
    }

    public String getTipo() {
        return "Monitor Cardíaco";
    }
}

class SensorOxigenacao extends DispositivoMedico {
    public String coletarDados() {
        int saturacao = new Random().nextInt(10) + 90;
        if (saturacao < 95) {
            return "Alerta: Saturação baixa: " + saturacao + "%";
        }
        return "Saturação normal: " + saturacao + "%";
    }

    public String getTipo() {
        return "Sensor de Oxigenação";
    }
}

public class SistemaMonitoramento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<PacienteInternado> internados = new ArrayList<>();
        ArrayList<Paciente> pacientes = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar Paciente Internado");
            System.out.println("2 - Adicionar Paciente Ambulatorial");
            System.out.println("3 - Adicionar Paciente de Emergência");
            System.out.println("4 - Conectar Dispositivo a Paciente Internado");
            System.out.println("5 - Monitorar Pacientes Internados");
            System.out.println("6 - Atender Paciente de Emergência");
            System.out.println("7 - Listar Todos os Pacientes");
            System.out.println("0 - Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nomeI = sc.nextLine();
                    System.out.print("Idade: ");
                    int idadeI = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Status de saúde: ");
                    String statusI = sc.nextLine();
                    PacienteInternado pi = new PacienteInternado(nomeI, idadeI, statusI);
                    pacientes.add(pi);
                    internados.add(pi);
                    System.out.println("Paciente internado adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nomeA = sc.nextLine();
                    System.out.print("Idade: ");
                    int idadeA = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Status de saúde: ");
                    String statusA = sc.nextLine();
                    pacientes.add(new PacienteAmbulatorial(nomeA, idadeA, statusA));
                    System.out.println("Paciente ambulatorial adicionado com sucesso!");
                    break;

                case 3:
                    System.out.print("Nome: ");
                    String nomeE = sc.nextLine();
                    System.out.print("Idade: ");
                    int idadeE = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Status de saúde: ");
                    String statusE = sc.nextLine();
                    PacienteEmergencia pe = new PacienteEmergencia(nomeE, idadeE, statusE);
                    pacientes.add(pe);
                    System.out.println("Paciente de emergência adicionado com sucesso!");
                    break;

                case 4:
                    if (internados.isEmpty()) {
                        System.out.println("Nenhum paciente internado cadastrado.");
                        break;
                    }
                    System.out.println("Selecione o paciente internado:");
                    for (int i = 0; i < internados.size(); i++) {
                        System.out.println(i + " - " + internados.get(i).getNome());
                    }
                    int indicePaciente = sc.nextInt();
                    if (indicePaciente < 0 || indicePaciente >= internados.size()) {
                        System.out.println("Índice inválido.");
                        break;
                    }
                    System.out.println("Escolha o dispositivo:");
                    System.out.println("1 - Monitor Cardíaco");
                    System.out.println("2 - Sensor de Oxigenação");
                    int dispositivoOp = sc.nextInt();

                    DispositivoMedico dispositivo;
                    if (dispositivoOp == 1) {
                        dispositivo = new MonitorCardiaco();
                    } else {
                        dispositivo = new SensorOxigenacao();
                    }
                    internados.get(indicePaciente).conectarDispositivo(dispositivo);
                    break;

                case 5:
                    for (PacienteInternado p : internados) {
                        p.monitorar();
                    }
                    break;

                case 6:
                    boolean encontrouEmergencia = false;
                    for (Paciente p : pacientes) {
                        if (p instanceof PacienteEmergencia) {
                            ((PacienteEmergencia) p).atenderUrgencia();
                            encontrouEmergencia = true;
                        }
                    }
                    if (!encontrouEmergencia) {
                        System.out.println("Nenhum paciente de emergência cadastrado.");
                    }
                    break;

                case 7:
                    for (Paciente p : pacientes) {
                        System.out.println("Nome: " + p.getNome() + ", Idade: " + p.getIdade() + ", Status: " + p.getStatusSaude() + ", Tipo: " + p.getClass().getSimpleName());
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema.");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}