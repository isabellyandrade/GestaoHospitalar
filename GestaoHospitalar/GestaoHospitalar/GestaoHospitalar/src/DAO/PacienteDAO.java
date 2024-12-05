
package DAO;

import gestaohospitalar.Paciente;
import java.util.ArrayList;
import java.util.List;


public class PacienteDAO {
    private List<Paciente> pacientes;

    public PacienteDAO() {      
        pacientes = new ArrayList<>();        
    }
    
    public void adicionarPaciente(Paciente paciente){
        pacientes.add(paciente);
    }
    
    public boolean deletarPaciente(Paciente paciente){
        Paciente existeP=buscarPacientePorId(paciente.getIdentidade());
        if(existeP!=null){
            pacientes.remove(paciente);
            return true;
        }
        return false;
    }
    
    public boolean atualizarPaciente(String id, Paciente pacienteAtualizado) {
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente p = pacientes.get(i);
            if (p.getIdentidade().equals(id)) {
                pacientes.set(i, pacienteAtualizado);
                return true;
            }
        }
        return false;
    }
    
    public Paciente buscarPacientePorId(String id) {
        for (Paciente p : pacientes) {
            if (p.getIdentidade().equals(id)) {
                return p;
            }
        }
        return null; 
    }
    public String listarTodosPacientes(){
        String report="";
        for(Paciente p: pacientes){
            report+=p.getIdentidade()+"\n";
            report+=p.getNome()+"\n";
            report+=p.getCpf()+"\n";
            report+=p.getNomeConvenio()+"\n";
        }
        return report;
    }
}
