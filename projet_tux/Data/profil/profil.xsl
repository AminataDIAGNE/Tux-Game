<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : profil.xsl
    Created on : 28 octobre 2022, 16:58
    Author     : dembeleo
    Description:
        Purpose of transformation follows.
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
                xmlns:prof="http://myGame/tux"
                version="1.0">
    <xsl:output method="html"/>
    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>profil.xsl</title>
            </head>
            <body>
                <table style="width:100%">
                    <tr>
                        <td>
                            <h1> 
                                <xsl:value-of select="/prof:profil/nom"/> 
                            </h1>
                        </td>                        
                        <xsl:variable name="photo" select="//prof:avatar"/>
                        <td> 
                            <img  src = "$photo" width="100" height="100" />
                        </td>    
                    </tr>
                    <tr>
                        <td>
                            <h3> Née le : <xsl:value-of select="//prof:anniversaire"/> </h3>
                        </td>
                    </tr>
                </table>
                <br/>
                <br/>
                <table style="width:100%" border="1">
                    <tr>
                        <th>Partie</th>
                        <th>Date</th> 
                        <th>Temps</th>
                        <th>Mot</th>
                    </tr>
                    <xsl:apply-templates select="//prof:partie"/>
                </table>
                
            </body>   
        </html>
    </xsl:template>

    <xsl:template match="prof:partie">        
        <tr>
            <td> 
                <xsl:value-of select="position()"/> 
            </td>     
            <td> 
                <xsl:value-of select="@date"/>
            </td>    
            <td> 
                <xsl:value-of select="prof:temps/text()"/>
            </td>    
            <td> 
                <xsl:value-of select="prof:mot/text()"/>
            </td>   
        </tr> 
    </xsl:template>
</xsl:stylesheet>
