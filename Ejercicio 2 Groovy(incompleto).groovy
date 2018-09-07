class Estudiante{

    //atributos
    String nombre;
    int dni;
    int edad;
    String ciudadNatal;
    float calificacion;

    //constructor
    Estudiante(String nombre,int dni,int edad,String ciudadNatal,float calificacion){
        this.nombre=nombre;
        this.dni=dni;
        this.edad=edad;
        this.ciudadNatal=ciudadNatal;
        this.calificacion=calificacion;
    }

}

class Curso{

    ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
    

    //Metodos
    
    //Pone en cero las calificaciones de todos los estudiantes.
    void resetearNotas(){
        int i;
        for(i=0; i < estudiantes.size(); i++){
            estudiantes[i].setCalificacion(0);
        }
    }
    
    //Agrega unEstudiante al curso
    void agregarEstudiante(unEstudiante){
        estudiantes.add(unEstudiante);
    }

    //Retorna la cantidad de alumnos que se inscribieron al curso
    void cantidadDeEstudiantesInscriptos(){
        int i;
        i=estudiantes.size()
        println "La cantidad de estudiantes inscriptos es: ${i}"
    }

    //#estudiantes(): Retorna la colección de estudiantes del curso
    void estudiantes(){
    int j;
    println "ESTUDIANTES DEL CURSO:"
    for(j=0; j<estudiantes.size(); j++)
        println "Nombre: ${estudiantes[j].nombre} - DNI: ${estudiantes[j].dni} - Edad: ${estudiantes[j].edad} - Ciudad Natal: ${estudiantes[j].ciudadNatal} - Calificacion: ${estudiantes[j].calificacion}"
    }
    
    
    //Retorna una colección con todos los estudiantes que aprobaron el curso(calificación superior a 4)
    void estudiantesAprobados(){
        int j;
        println "ESTUDIANTES APROBADOS CON NOTA MAYOR A 4:"
        for(j=0; j<estudiantes.size(); j++){
            if(estudiantes[j].calificacion > 4){
                println "Nombre: ${estudiantes[j].nombre} - DNI: ${estudiantes[j].dni} - Edad: ${estudiantes[j].edad} - Ciudad Natal: ${estudiantes[j].ciudadNatal} - Calificacion: ${estudiantes[j].calificacion}"
            }
        }
    }


    //Indica si “unEstudiante” se encuentra inscripto en el curso
    void existeEstudiante(int dni){
        int k,j=0;
        for(k=0; k<estudiantes.size(); k++){
            if(dni == estudiantes[k].dni){
                println "EL ALUMNO CON DNI: ${dni} se encuentra inscripto en el curso"
                j=1
                break;
            }
        }
        if(j==0)
            println "EL ALUMNO CON DNI: ${dni} NO se encuentra inscripto en el curso"
    }


    //Determina si algún alumno obtuvo la calificación 10
    void existeEstudianteConNotaDiez(){
        println "ALUMNOS CON NOTA IGUAL A DIEZ: "
        int k;
        for(k=0; k<estudiantes.size(); k++){
            if(estudiantes[k].calificacion==10){
                println ("Nombre: ${estudiantes[k].nombre} - DNI: ${estudiantes[k].dni}");
            }
        }
    }

    //Indica si el estudiante llamado “unNombre” se encuentra inscripto en el curso
    void existeEstudianteLlamado(String nombre){
        int k,j=0;
        for(k=0; k<estudiantes.size(); k++){
            if(nombre == estudiantes[k].nombre){
                println "EL ALUMNO CON EL NOMBRE: ${nombre} se encuentra inscripto en el curso"
                j=1
                break;
            }
        }
        if(j==0)
            println "EL ALUMNO CON EL NOMBRE: ${nombre} NO se encuentra inscripto en el curso"
    }

    //Retorna en porcentaje de estudiantes aprobados
    void porcentajeDeAprobados(){
        int j,cantAprobados=0,porcentaje;
        for(j=0; j<estudiantes.size(); j++){
            if(estudiantes[j].calificacion > 4){
                cantAprobados++
            }
        }
        porcentaje=(cantAprobados*100)/estudiantes.size()
        println"EL PORCENTAJE DE ALUMNOS APROBADOS ES: ${porcentaje}%"
    }
    
    
    //Calcula el promedio de las calificaciones obtenidas por los alumnos
    void promedioDeCalificaciones(){
        int j,notaTotal=0
        for(j=0; j<estudiantes.size(); j++){
           notaTotal=notaTotal+(estudiantes[j].calificacion) 
        }
        println"EL PROMEDIO DE LAS CLASIFICACIONES OBTENIDAS POR LOS ALUMNOS ES: ${notaTotal/estudiantes.size()}" 
    }
    
    //Retorna una colección con todos los estudiantes que no nacieron en Catamarca
    void estudiantesNoCatamarquenios(){
        int j
        String ciudad="CATAMARCA"
        for(j=0; j<estudiantes.size(); j++){
            if(estudiantes[j].ciudadNatal.toUpperCase() != ciudad){
                println"EL ALUMNO: ${estudiantes[j].nombre} ,NO NACIO EN CATAMARCA"
            }
        }
    }    
     
     
    //#calificacionMasFrecuente(): Retorna la calificación más frecuente del curso
    
    //#ciudadesExceptoCatamarca(): Retorna una colección, sin repeticiones, conteniendo los nombres de todas las 
    //ciudades (excepto Catamarca) donde nacieron los alumnos inscriptos al curso
    
    //frecuenciaDeEdades(): Retorna un mapa que asocia las edades de los estudiantes con la frecuencia en la que aparecen. 
    //Esta información luego será utilizada para generar un histograma (ver Figura 3) cuyo eje x serán las edades y 
    //cuyo eje y serán la frecuencia de las ocurrencias
    
    
    //Retorna verdadero si todos los estudiantes desaprobaron el curso
    boolean unDesastre(){
        int j, desaprobados=0
        for(j=0; j<estudiantes.size(); j++){
            if(estudiantes[j].calificacion < 4){
                desaprobados++
            }
        }
        if(desaprobados==estudiantes.size()){return true}
        else{return false}
    }
   
   
   
}

 def curso = new Curso();

curso.agregarEstudiante(new Estudiante("fabri",39424149,24,"Catamarca",10))
curso.agregarEstudiante(new Estudiante("facu",37654210,23,"Catamarca",3))
curso.agregarEstudiante(new Estudiante("matias",38634290,23,"Tucuman",6))
curso.agregarEstudiante(new Estudiante("daniel",39805908,21,"Catamarca",7))


curso.cantidadDeEstudiantesInscriptos()

curso.estudiantes()

curso.estudiantesAprobados()

curso.existeEstudiante(37654210)
curso.existeEstudiante(37616110)

curso.existeEstudianteLlamado("fabri")
curso.existeEstudianteLlamado("lucas")

curso.existeEstudianteConNotaDiez();

curso.porcentajeDeAprobados()

curso.promedioDeCalificaciones()

curso.estudiantesNoCatamarquenios()

if(true==curso.unDesastre())
    println "TODOS LOS ALUMNOS ESTAN DESAPROBADOS"