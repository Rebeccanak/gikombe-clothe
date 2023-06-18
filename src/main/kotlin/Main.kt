fun main() {

    val theDjembe = TheDjembe("wood", "small")
    theDjembe.playSounds("heavy")

    val theTalkingDrum = TalkingDruming("leather", "huge", "3 feet")
    theTalkingDrum.playSounds("much")

    val theBougarabous = Bougarabous("animalskin", "big")
    theBougarabous.playSounds("deep")

    val drySeason = Seasons("dry")
    println(drySeason.predictFruit())

    val newMigrate = GreatMigration("dry", "low")
    newMigrate.migratingAnimals()


    val pattern = AnkaraDesign(25, 3)
    pattern.predictDesign()

    val listOfExpenses = listOf(
        MovieExpenses("makeup",3000.0),
    MovieExpenses("materials",5000.0),
    MovieExpenses("payment",10000.0),
    MovieExpenses("casts",5000.0)
            )
    val compareCosts =checkBudget(30000.0)

    var wolf =MoviePlanners("The lion King","June 2 - June 30","Rebecca",30000.0)
    val movie1 = MoviePlanners("The Dark Knight", "8:00 PM", "Christian Bale, Heath Ledger", 1000000.0)
    val movie2 = MoviePlanners("Inception", "10:00 PM", "Leonardo DiCaprio, Ellen Page", 1500000.0)

//    movie1.addMovie(movie2)
    movie1.checkMovies(movie2)


//    val listExpenses = listOf(
//        MovieProjects("June 1 -June 20","John",3000.0),
//        MovieProjects("July 1-july 20","Eunice",3000.0),
//        MovieProjects("August 1- August20","Becky",6000.0)
//    )
//    val comparebudget =checkBudget(40000.0)
//
//    val becky =MovieProjects("December 1 - December 20","Miriram",3000.0)
//
//becky.addMovie("d")






}
//You’re part of a community that hosts one of the largest drum circles in Africa.
//There are different types of traditional drums used in the circle, each with its
//unique sound and rhythm. The Djembe, Talking Drum, and Bougarabou are among the
//popular ones. These drums have common properties such as the material
//they’re made from and their sizes, but they also have distinct characteristics.
//For instance, the Talking Drum can mimic the lines of human speech, the Djembe
//is known for its wide range of tones, and the Bougarabou is noted for its deep, rich bass tones.
//You want to create a software model of the drum circle that encapsulates these
//different types of drums. You wish to include methods for each drum that represent
//the sound it makes, and also group similar drums together. Think about creating a base Drum
//class that contains properties and methods common to all drums, and then create subclasses
//for each specific type of drum (like Djembe, TalkingDrum, and Bougarabou).
//The subclasses should inherit from the base Drum class and also implement their unique
//characteristics. This software model would help newcomers understand the characteristics.
//This software model would help newcomers understand the characteristics of each drum and how they
//contribute to the overall rhythm of the drum circle.

open class Druming(private val material: String, private val size: String) {
    open fun playSounds(tones: String) {
        println("Produces high $tones tones of sounds")
        println("This ${this::class.simpleName} drum is made of $material and is of size $size")
    }
}

class TheDjembe(material: String, size: String) : Druming(material, size) {
    override fun playSounds(tones: String) {
        super.playSounds(tones)
        println("The Djembe produces a wide range of $tones of sound")
    }
}

class TalkingDruming(material: String, size: String, private val height: String) : Druming(material, size) {
    override fun playSounds(tones: String) {
        super.playSounds(tones)
        println("Mimics the lines of human $tones speech and has $height")
    }
}

class Bougarabous(material: String, size: String) : Druming(material, size) {
    override fun playSounds(tones: String) {
        super.playSounds(tones)
        println("Produces deep rich base $tones")
    }
}

// The Magical Baobab: In a small village there is a Baobab tree believed to have magical
// properties.Every season it bear different types of fruits, each with its own unique power.
// You have decided to create a software system that tracks the changes in the tree and predicts
// what type of fruit it will bear next season and what powers it will possess. The system should
// also record the effect o each each
// fruit hen consumed

class Baobab(val fruit: String, val season: String, val power: String, val effects: String)

val fruits = mutableListOf<Baobab>()
val firstFruits = Baobab("baobab fruit", "dry", "energetic", "strength")
//fruits.add(firstFruits)

class Seasons(val season: String) {
    fun predictFruit(): List<Baobab> {
        return fruits.filter { it.season == season }
    }
}

//Nolly Wood Movie Planner:AS a producer in the booming Nollywood movie industry , you are in charge
// of multiple film projects at once.Each movie has different cast members , shooting schedules ,
// and budgets . You want to write a program to help manage your film projects efficiently .
// The software should be able to handle he complexities of scheduling ,budgeting and
// coordinating between different movie projects.
// do it in kotlin
class MovieProject(val title: String, var castMembers: MutableList<String>,
                   var shootingSchedule: String, var budget: Double
) {
    fun addCastMember(castMember: String) {
        castMembers.add(castMember)
    }
    fun removeCastMember(castMember: String) {
        if (castMembers.contains(castMember)) {
            castMembers.remove(castMember)
        } else {
            println("$castMember is not a cast member of this project.")
        }
    }
    fun updateShootingSchedule(schedule: String) {
        shootingSchedule = schedule
    }
    fun adjustBudget(amount: Double) {
        if (budget + amount >= 0) {
            budget += amount
        } else {
            println("Error: Budget cannot be negative.")
        }
    }
}
class MoviePlanner {
    val projects = mutableListOf<MovieProject>()
    fun addProject(project: MovieProject) {
        projects.add(project)
    }
    fun removeProject(project: MovieProject) {
        if (projects.contains(project)) {
            projects.remove(project)
        } else {
            println("${project.title} is not a project in the planner.")
        }
    }
    fun updateProjectDetails(project: MovieProject, castMembers: MutableList<String>, schedule: String, budget: Double) {
        project.castMembers = castMembers
        project.shootingSchedule = schedule
        project.budget = budget
    }
    fun generateReport() {
        for (project in projects) {
            println("Title: ${project.title}")
            println("Cast Members: ${project.castMembers}")
            println("Shooting Schedule: ${project.shootingSchedule}")
            println("Budget: ${project.budget}")
            println()
        }
    }
}

//Great migration Forecast. Every year, millions of wildebeest, zebras, and other animals participate
// in great migration across the Serengeti -Mara ecosystem. As a conservationist, you want to develop
// a software system that models this migration, predicting the movement of the herds based on the
// weather patterns, rivers levels, predator locations, and the various factors that influence the
// migration

class GreatMigration(private val weatherPatterns: String, private val riverLevels: String) {
    fun migratingAnimals() {
        when {
            weatherPatterns == "dry" || riverLevels == "low" -> println("The migration will occur")
            weatherPatterns == "wet" || riverLevels == "high" -> println("Migration will not occur")
            else -> println("Migration did not change")
        }
    }
}
//The Ever-changing you are a fashion designer known for your unique and vibrant Ankara designs
// . Recently , you have discovered that some of your fabric patterns change their designs based
// o the temperature and mood of the wearer.You want to create a software application that can
// predict the changes in the fabric design given the mood and temperature data .
// Think about the classes you will need to model the changing Ankara and how to predict the changes
// do it in the languages below
class AnkaraDesign(private val temperature: Int, private val mood: Int) {
    fun predictDesign() {
        val temp = 20
        val mood = 5
        if (this.temperature >= temp || this.mood == mood) {
            println("the design changed to floral")
        } else if (this.temperature < temp || this.mood != mood) {
            println("the design changed to black patterns")
        } else {
            println("The design was detained")
        }
    }
}
//data class  MovieExpenses (var expenses:String,var costs:Double)
//fun checkBudget(allocatedBudget:Double){
//    val expense1=MovieExpenses("transport",2000.0)
//    val expense2=MovieExpenses("props",3000.0)
//    val expense3=MovieExpenses("directors",4000.0)
//    val expense4=MovieExpenses("casts",5000.0)
//    var listOfExpenses= listOf<MovieExpenses>(expense1,expense2,expense3,expense4)
////    var totalCost=listOfExpenses.sumByDouble { it.costs }
//    var totalCost = listOfExpenses.map{it.costs}.reduce{a,b -> a+b}
////    map is used to extract the costs values from each MovieExpenses instance and create a new list of costs .
////    reduce is applied to the list of costs, which repeatedly combines the elements using the specified lambda function {a,b -> a+b}
////    The lambda function takes two parameters: a represents the accumulated sum, and b represents the current cost being processed.
////    The final accumulated value represents the total cost of all the expenses
////    The filter function is used to selectively filter elements based on a given condition, not for calculating a sum.
//    if (totalCost < allocatedBudget){
//        println("The total cost $totalCost is less than allocated budget $allocatedBudget for shooting the film")
//    }
//    else{
//        println("The total cost $totalCost exceeds the allocated budget $allocatedBudget for shooting the film")
//    }
//}
//
//class MovieProjects(var shedule:String,var castMember:String,var budget:Double){
//    var movies = mutableListOf<MovieProjects>()
//    fun addMovie(movie:MovieProjects){
//        movies.add(movie)
//        println(movies)
//    }
//    fun remove(movie: MovieProjects){
//        movies.remove(movie)
//        println(movies)
//
//    }
//
//
//
//       }


data class MovieExpenses(var expenses:String, var costs:Double)
fun checkBudget(allocatedBudget:Double){
    //here i create an object with the expenses and the cost for each object

    val expenses1 =MovieExpenses("makeup",3000.0)
    val expenses2=MovieExpenses("transport",4000.0)
    val expenses3=MovieExpenses("materials",5000.0)
    val expenses4=MovieExpenses("payment",10000.0)
    val expense4=MovieExpenses("casts",5000.0)
    var listOfExpenses = listOf<MovieExpenses>(expenses1,expenses2,expenses3,expenses4)
    var totalCosts =listOfExpenses.sumByDouble { it.costs }
    if(totalCosts > allocatedBudget){
        println("The total cost $totalCosts exceeds the allocated budget $allocatedBudget")
    }
    else{
        println("The total cost $totalCosts is less than the allocated budget $allocatedBudget")
    }


}
class MoviePlanners( val title:String, val schedule:String, val castMember:String, val budget:Double){
    //create an empty list that will hold the data
    var movies = mutableListOf<MoviePlanners>()
    //write the function now that can add movies or even remove them
//    fun addMovie(movie:MoviePlanners){
//        movies.add(movie)
    fun checkMovies(movie:MoviePlanners){
        for (movie in movies){
            if (movies.isEmpty()){
                println("no movie found")
            }
            else{
                println("Movie is found")
            }
            for(movie in movies){
                println("- $movie")
        }
            fun addMovie(movie: MoviePlanners){
                if (movies.contains(movie)){
                    movies.remove(movie)
                    println("movie removed successfully")
                }
                else{
                    println("Movie was not found")
                }
            }
    }
}



    }



















