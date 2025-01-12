import java.io.PrintWriter

open class DimenFactory : DefaultTask() {
    // For portrait
    private val dimens = intArrayOf(
        // < 360 small
        // 360 -> 400 medium
        // 400 -> 480 large
        // 480 -> 600 xlarge phone
        // 600 -> 720 small tablet
        // 720 -> 800 large tablet
        // > 800 xlarge tablet
        320, 360, 389, 410, 440, 480, 540, 600, 640, 720, 800, 960, 1024, 1080
    )
    private val fromDimen = 410f // pixel 3a pretty same design iphone x design
    private val positiveMaxDP = 450
    private val positiveMaxSP = 60
    private val negativeMaxDP = 60
    private val resFolder = project.projectDir.path + "/src/main/res/"

    @TaskAction
    fun create() {
        autoCreateDimen()
    }

    private fun autoCreateDimen() {
        // write dimen.xml
        val defaultFolder = resFolder + "values"
        val defaultDimensFile = "$defaultFolder/dimens.xml"
        File(defaultFolder).mkdir()
        File(defaultDimensFile).createNewFile()

        // write default dimension for values folder
        writeAutoDimen(defaultDimensFile, fromDimen.toInt())

        // write other auto_dimens.xml
        for (dimen in dimens) {
            val folder = resFolder + "values-sw" + dimen + "dp"
            val fileName = "$folder/auto_dimens.xml"
            File(folder).mkdir()
            File(fileName).createNewFile()
            writeAutoDimen(fileName, dimen)
        }
    }

    private fun writeAutoDimen(fileName: String, dimen: Int) {
        println("Auto create dimension file and values $fileName")
        val printWriter = PrintWriter(fileName)
        val ratio = dimen / fromDimen
        printWriter.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>")
        printWriter.println("<resources>")
        printWriter.println("\t<string name=\"dimension_file\">dimension_$dimen</string>\r\n")
        for (i in 0..positiveMaxDP) {
            val dp = ratio * i
            printWriter.printf("\t<dimen name=\"dp_%d\">%.2fdp</dimen>\r\n", i, dp)
        }
        printWriter.println()
        for (i in 1..negativeMaxDP) {
            val dp = ratio * i
            printWriter.printf("\t<dimen name=\"dp_minus%d\">%.2fdp</dimen>\r\n", i, -dp)
        }
        printWriter.println()
        for (i in 1..positiveMaxSP) {
            val sp = ratio * i
            printWriter.printf("\t<dimen name=\"sp_%d\">%.2fsp</dimen>\r\n", i, sp)
        }
        printWriter.println("</resources>")
        printWriter.close()
    }
}

tasks.register("createDimen", DimenFactory::class) {
    create()
}
