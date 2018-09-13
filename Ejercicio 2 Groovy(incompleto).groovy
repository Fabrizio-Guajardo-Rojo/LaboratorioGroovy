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

    List estudiantes = []

    //Metodos
    
    //Pone en cero las calificaciones de todos los estudiantes.
    void resetearNotas(){
        this.estudiantes.each{it.calificacion=0}
    }
        
    //Agrega unEstudiante al curso
    void agregarEstudiante(unEstudiante){
        estudiantes.add(unEstudiante);
    }

    //Retorna la cantidad de alumnos que se inscribieron al curso
    void cantidadDeEstudiantesInscriptos(){
        def i;
        i=estudiantes.size()
        println "La cantidad de estudiantes inscriptos es: ${i}"
    }

    //Retorna la colección de estudiantes del curso
    List estudiantes(){
        return this.estudiantes
    }

    //Retorna una colección con todos los estudiantes que aprobaron el curso(calificación superior a 4)
    List estudiantesAprobados(){
        return this.estudiantes.findAll{it.calificacion>4}
    }
    
    //Indica si “unEstudiante” se encuentra inscripto en el curso
    Boolean existeEstudiante(unEstudiante){
        return this.estudiantes.any{it.dni==unEstudiante.dni}
    }

    //Determina si algún alumno obtuvo la calificación 10
    Boolean existeEstudianteConNotaDiez(){
        return this.estudiantes.any{it.calificacion==10}
    }

    //Indica si el estudiante llamado “unNombre” se encuentra inscripto en el curso
    Boolean existeEstudianteLlamado(unNombre){
        return this.estudiantes.any{it.nombre.equals(unNombre)}
    }

    //Retorna en porcentaje de estudiantes aprobados
    def porcentajeDeAprobados(){
        def j,cantAprobados=0,porcentaje;
        for(j=0; j<estudiantes.size(); j++){
            if(estudiantes[j].calificacion > 4){
                cantAprobados++
            }
        }
        porcentaje=(cantAprobados*100)/estudiantes.size()
        return porcentaje
    }
    
    //Calcula el promedio de las calificaciones obtenidas por los alumnos
    void promedioDeCalificaciones(){
        def j,notaTotal=0
        for(j=0; j<estudiantes.size(); j++){
           notaTotal=notaTotal+(estudiantes[j].calificacion) 
        }
        println"EL PROMEDIO DE LAS CLASIFICACIONES OBTENIDAS POR LOS ALUMNOS ES: ${notaTotal/estudiantes.size()}" 
    }
    
    //Retorna una colección con todos los estudiantes que no nacieron en Catamarca
    //List estudiantesNoCatamarquenios(){
    //    return this.estudiantes.findAll{it.ciudadNatal.equals(aString)}
    //}
    void estudiantesNoCatamarquenios(){
        def j
        def ciudad="CATAMARCA"
        for(j=0; j<estudiantes.size(); j++){
            if(estudiantes[j].ciudadNatal.toUpperCase() != ciudad){
                println"EL ALUMNO: ${estudiantes[j].nombre} ,NO NACIO EN CATAMARCA"
            }
        }
    }    
       
	//Retorna la calificación más frecuente del curso
	def calificacionMasFrecuente() {
    	List notas=[]

    	notas= this.estudiantes.calificacion

    	def i;
    	def j=0 
      
    	List contador = []
    	for (i=0; i < 20 ;i++){
        	contador[i]=0
    	}

    	for (j=0; j < notas.size();j++){
        	for (i=0; i < notas.size();i++){
            	if (notas[j] == notas[i]){
             		contador[j]=contador[j] + 1
            	}
        	}
    	}

    	int iNumeroMayor, iPosicion;
 
		//Suponemos que el numero mayor es el primero
    	iNumeroMayor = contador[0];
    	iPosicion = 0;
    	for (i=1;i <contador.size();i++){
        	if (contador[i]>iNumeroMayor){
           		iNumeroMayor = contador[i];
           		iPosicion = i;
        	} 
    	}
    	
    	return estudiantes[iPosicion].calificacion
	}
    
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

//Agrega estudiantes
curso.agregarEstudiante(new Estudiante("fabri",39424149,24,"Catamarca",10))
curso.agregarEstudiante(new Estudiante("facu",37654210,23,"Catamarca",3))
curso.agregarEstudiante(new Estudiante("matias",38634290,23,"Tucuman",10))
curso.agregarEstudiante(new Estudiante("daniel",39805908,21,"Catamarca",7))

//resetea la nota de todos los estudiantes a cero
//curso.resetearNotas()

//muestra una lista de los nombres de los aprobados
println curso.estudiantesAprobados().nombre

//muestra true si existe un estudiante con ese nombre
println curso.existeEstudianteLlamado("daniel")

//muestra la cantidad de estudiantes inscriptos en el curso
curso.cantidadDeEstudiantesInscriptos()

//muestra una lista con los nombres de los estudiantes del curso
println curso.estudiantes().nombre

//muestra true si existe el alumno que le enviamos
def alumno = new Estudiante("daniel",39805908,21,"Catamarca",7)
println curso.existeEstudiante(alumno)

//muestra true si existe algun estudiante con nota igual a 10
println curso.existeEstudianteConNotaDiez()

//muestra el porcentaje de estudiantes aprobados
println"EL PORCENTAJE DE ALUMNOS APROBADOS ES: ${curso.porcentajeDeAprobados()}%"
//muestra el promedio de las calificaciones
curso.promedioDeCalificaciones()

// muestra estudiantes no catamarqueños REVISAR
curso.estudiantesNoCatamarquenios()

//MUESTRA la calificacion mas frecuente 
println "LA CALIFICACION MAS FRECUENTE ES: ${curso.calificacionMasFrecuente()}"
// Muestra un verdadero si todos los alumnos estan desaprobados 
println curso.unDesastre()