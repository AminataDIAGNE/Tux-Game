<?xml version="1.0" encoding="UTF-8"?>
<!--Aminata-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
                xmlns:ns1='http://univ-grenoble-alpes.fr/Dembele/Mot' version="1.0">
    <xsl:output method="html"/>
    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>dico.xsl</title>
            </head>
            <body>
                <table style="width:100%" border="1" >
                    <tr bgcolor="#FFFF00">
                        <th>Mot</th>
                        <th>Niveau</th>
                    </tr> 
                    <xsl:apply-templates select="/ns1:dictionnaire/ns1:mot">
                        <xsl:sort select="@niveau" order="ascending"/>
                        <xsl:sort select="text()" order="ascending"/>  
                    </xsl:apply-templates>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="ns1:mot">
        <tr>
            <th>
                <ul>
                    <xsl:value-of select="text()"/> 
                </ul> 
            </th>
            <th>
                <xsl:value-of select="@niveau"/>
            </th>
        </tr>
    </xsl:template>
</xsl:stylesheet>
