/*
 * Copyright (c) 2002-2020, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.util.url;

import fr.paris.lutece.test.LuteceTestCase;

/**
 * UrlItem Test Class
 */
public class UrlItemTest extends LuteceTestCase
{
    /**
     * Test of addParameter method, of class fr.paris.lutece.util.url.UrlItem.
     */
    public void testUrlItem( )
    {
        System.out.println( "addParameter" );

        String strName = "param";
        String strValue = "value";

        // Add a parameter to an url that have no parameter
        UrlItem url = new UrlItem( "http://myhost/mypage.jsp" );
        url.addParameter( strName, strValue );
        assertEquals( "http://myhost/mypage.jsp?param=value", url.getUrl( ) );

        // Add a parameter to an url that have already one or more parameters
        url = new UrlItem( "http://myhost/mypage.jsp?param2=value2" );
        url.addParameter( strName, strValue );

        assertEquals( "http://myhost/mypage.jsp?param2=value2&param=value", url.toString( ) );
    }

    public void testUrlItemWithSpecialCharacterInKey( )
    {
        String strName = "Lutèce";
        String strValue = "value";
        Integer strValueInt = 11;

        // Add a parameter to an url that have no parameter
        UrlItem url = new UrlItem( "http://myhost/mypage.jsp" );
        url.addParameter( strName, strValue );
        assertEquals( "http://myhost/mypage.jsp?Lut%C3%A8ce=value", url.getUrl( ) );

        // Add a parameter to an url that have no parameter
        url = new UrlItem( "http://myhost/mypage.jsp" );
        url.addParameter( strName, strValueInt );
        assertEquals( "http://myhost/mypage.jsp?Lut%C3%A8ce=11", url.getUrl( ) );
    }

    public void testUrlItemWithSpecialCharacterInValue( )
    {
        String strName = "param";
        String strValue = "Árvíztűrőfúrógép";

        // Add a parameter to an url that have no parameter
        UrlItem url = new UrlItem( "http://myhost/mypage.jsp" );
        url.addParameter( strName, strValue );
        assertEquals( "http://myhost/mypage.jsp?param=%C3%81rv%C3%ADzt%C5%B1r%C5%91f%C3%BAr%C3%B3g%C3%A9p", url.getUrl( ) );
    }

    /**
     * Test of addAnchor method, of class fr.paris.lutece.util.url.UrlItem.
     */
    public void testAnchorSimple( )
    {
        // Add a parameter to an url that have no parameter
        UrlItem url = new UrlItem( "http://myhost/mypage.jsp" );

        url.setAnchor( "bar" );
        assertEquals( "http://myhost/mypage.jsp#bar", url.getUrl( ) );
    }

    /**
     * Test of addAnchor method, of class fr.paris.lutece.util.url.UrlItem.
     */
    public void testAnchor( )
    {
        // Add a parameter to an url that have no parameter
        UrlItem url = new UrlItem( "http://myhost/mypage.jsp" );

        String strName = "param";
        String strValue = "value";

        url.addParameter( strName, strValue );
        url.setAnchor( "bar" );
        assertEquals( "http://myhost/mypage.jsp?param=value#bar", url.getUrl( ) );
    }
}
