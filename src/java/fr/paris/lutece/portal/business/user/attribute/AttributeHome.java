/*
 * Copyright (c) 2002-2010, Mairie de Paris
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
package fr.paris.lutece.portal.business.user.attribute;

import java.util.List;
import java.util.Locale;

import fr.paris.lutece.portal.service.spring.SpringContextService;

/**
 * 
 * AttributeHome
 *
 */
public class AttributeHome
{
	private static IAttributeDAO _dao = (IAttributeDAO) SpringContextService.getBean( "attributeDAO" );;
	
	/**
	 * Load attribute
	 * @param nIdAttribute ID Attribute
	 * @param locale Locale
	 * @return Attribute 
	 */
	public static AbstractAttribute findByPrimaryKey( int nIdAttribute, Locale locale )
	{
		return _dao.load( nIdAttribute, locale );
	}
		
	/**
	 * Insert an new attribute
	 * @param attribute attribute
	 * @return new PK
	 */
	public static int create( AbstractAttribute attribute )
	{
		return _dao.insert( attribute );
	}
	
	/**
	 * Update an attribute
	 * @param attribute the attribute
	 */
	public static void update( AbstractAttribute attribute )
	{
		_dao.store( attribute );
	}
	
	/**
	 * Delete an attribute
	 * @param nIdAttribute The id of the attribute
	 */
	public static void remove( int nIdAttribute )
	{
		_dao.delete( nIdAttribute );
	}

	/**
	 * Load every attributes
	 * @param locale locale
	 * @return list of attributes
	 */
	public static List<AbstractAttribute> findAll( Locale locale )
	{
		return _dao.selectAll( locale );
	}
}
