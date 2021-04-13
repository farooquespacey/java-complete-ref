<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="xml" indent="yes"/>
<xsl:strip-space elements="*"/>

  <!-- IdentityTransform -->
  <xsl:template match="@*|node()">
    <xsl:copy>
      <xsl:apply-templates select="@*|node()"/>
    </xsl:copy>
  </xsl:template>

<xsl:template match="product/*[not(local-name()='sku' or
                                   local-name()='name' or
                                   local-name()='department')]">
<!-- ALTERNATIVE:  -->
<!-- <xsl:template match="productId|source|type|startDate|new">  -->
</xsl:template>

</xsl:stylesheet>