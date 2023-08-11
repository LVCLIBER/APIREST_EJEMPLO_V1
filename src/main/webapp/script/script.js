const  btnModalregistro = document.getElementById('btn-abrir-modal');
const  cerraModal = document.getElementById('cerrar-modal');
const  cerraModalEditar = document.getElementById('cerrar-modal-editar');
const  contenedorModal = document.querySelector(".container-modal");
const  contenedorModalEditar = document.querySelector(".container-modalEditar");
const cerrarsidebar = document.getElementById('cerrar-sidebar');
const container = document.querySelector('.container');

function modalregistro() {
    contenedorModal.classList.toggle('active');
}
function modaleditar(dni, nombre, edad) {
contenedorModalEditar.classList.toggle('active');
    document.getElementById("ttdniE").value = dni;
    ttnombreE = document.getElementById("ttnombreE").value = nombre;
    document.getElementById("ttedadE").value = edad;   
}
function cerrarmodalE(){
   contenedorModalEditar.classList.toggle('active');   
}
function accionsidebar(){
    container.classList.toggle('active'); 

}
btnModalregistro.addEventListener('click', modalregistro);
cerraModal.addEventListener('click', modalregistro);
cerraModalEditar.addEventListener('click',cerrarmodalE);
cerrarsidebar.addEventListener('click', accionsidebar);



