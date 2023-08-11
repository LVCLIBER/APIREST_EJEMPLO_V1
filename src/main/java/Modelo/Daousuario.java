package Modelo;

import java.util.ArrayList;

public class Daousuario {

    private ArrayList<Musuario> listausuario = new ArrayList<>();

    public ArrayList<Musuario> getlistausuario() {
        return listausuario;
    }

    public boolean RegistrarUsuario(Musuario m) {
        listausuario.add(m);
        return true;
    }

   

    public void Editarusuario(Musuario m) {
        
        for (int i = 0; i < listausuario.size(); i++) {
              int posicion=i;
            if (listausuario.get(posicion).getDni() == m.getDni()) {
             //  listausuario.set(posicion, m);
             listausuario.get(posicion).setNombre(m.getNombre());
             listausuario.get(posicion).setEdad(m.getEdad());

            }

        }
     
    }
    public void  Eliminar(int dni){
        for (int i = 0; i < listausuario.size(); i++) {
            int posicion = i;
            if(listausuario.get(posicion).getDni()== dni){
                listausuario.remove(posicion);
            }
        }
     
    }

}
