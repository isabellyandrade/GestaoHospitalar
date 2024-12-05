
package DAO;

import gestaohospitalar.Medico;
import java.util.ArrayList;
import java.util.List;


public class MedicoDAO {
    private List<Medico> medicos;

    public MedicoDAO() {      
        medicos = new ArrayList<>();        
    }
    
    public void adicionarMedico(Medico medico){
        medicos.add(medico);
    }
    
    public boolean deletarMedico(Medico medico){
        Medico existeP=buscarMedicoPorId(medico.getIdentidade());
        if(existeP!=null){
            medicos.remove(medico);
            return true;
        }
        return false;
    }
    
    public boolean atualizarMedico(String id, Medico medicoAtualizado) {
        for (int i = 0; i < medicos.size(); i++) {
            Medico p = medicos.get(i);
            if (p.getIdentidade().equals(id)) {
                medicos.set(i, medicoAtualizado);
                return true;
            }
        }
        return false;
    }
    
    public Medico buscarMedicoPorId(String id) {
        for (Medico m : medicos) {
            if (m.getIdentidade().equals(id)) {
                return m;
            }
        }
        return null; 
    }
    public String listarTodosMedicos(){
        String report="";
        for(Medico m: medicos){
            report+=m.getIdentidade()+"\n";
            report+=m.getNome()+"\n";
            report+=m.getCrm()+"\n";
            report+=m.getEspecialidade()+"\n";            
        }
        return report;
    }
}
