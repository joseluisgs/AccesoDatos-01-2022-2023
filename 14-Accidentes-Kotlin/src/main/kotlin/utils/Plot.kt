package utils

import jetbrains.datalore.plot.PlotHtmlExport
import jetbrains.datalore.plot.PlotHtmlHelper.scriptUrl
import jetbrains.datalore.plot.PlotSvgExport
import jetbrains.letsPlot.export.VersionChecker
import jetbrains.letsPlot.intern.Plot
import jetbrains.letsPlot.intern.toSpec
import java.awt.Desktop
import java.io.File

fun openInBrowser(content: String, fileName: String) {
    val dir = File(System.getProperty("user.dir"), "lets-plot-images")
    dir.mkdir()
    val file = File(dir.canonicalPath, fileName)
    file.createNewFile()
    file.writeText(content)

    try {
        Desktop.getDesktop().browse(file.toURI())
    } catch (e: Exception) {
        println("Failed to open file in browser: $e")
    }
}

fun Plot.exportToHtml() =
    PlotHtmlExport.buildHtmlFromRawSpecs(this.toSpec(), scriptUrl(VersionChecker.letsPlotJsVersion))


fun Plot.exportToSvg() = PlotSvgExport.buildSvgImageFromRawSpecs(this.toSpec())
