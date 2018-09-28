<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method='xml' version='1.0' encoding='UTF-8' indent='yes'/>
    <xsl:template match="/">
        <html>
            <body>
                <img src="/home/fmurillom/Documents/Lenguajes/Proyecto3/src/bowsette.jpg" alt="" width="450" height="253"></img>
                <h1>Instituto Tecnologico de Costa Rica</h1>
                <p><strong>Seccion I Marque con X: </strong></p>
                <ol>
                    <xsl:for-each select="Quiz/MarqueX/Pregunta">
                        <li><xsl:value-of select="Enunciado"/>
                            <ol style="list-style-type: lower-alpha;">
                                <li><xsl:value-of select="Opcion1"/></li>
                                <li><xsl:value-of select="Opcion2"/></li>
                                <li><xsl:value-of select="Opcion3"/></li>
                                <li><xsl:value-of select="Opcion4"/></li>
                            </ol>
                        </li>
                    </xsl:for-each>
                </ol>
                <p><strong>Seccion II Respuesta Corta: </strong></p>
                <ol>
                    <xsl:for-each select="Quiz/Corta/Pregunta">
                        <li><xsl:value-of select="Enunciado"/></li>
                        <br></br>
                        <br></br>
                        <br></br>
                    </xsl:for-each>
                </ol>
                <p><strong>Seccion III Desarrollo: </strong></p>
                <ol>
                    <xsl:for-each select="Quiz/Desarrollo/Pregunta">
                        <li><xsl:value-of select="Enunciado"/></li>
                        <br></br>
                        <br></br>
                        <br></br>
                    </xsl:for-each>
                </ol>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

