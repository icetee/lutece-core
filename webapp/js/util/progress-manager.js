
function getProgress( id, feedToken, intervalTime ) {
    $.ajax({
        url: 'servlet/progressManager/progressFeed?progress&token=' + feedToken ,
        method: 'POST',
        async: true,
        success: function(data) {
        	updateProgressBar( id, parseInt(data.result) );
                if ( getProgressValue( id ) < getProgressMaxValue( id ) ) {
                    setTimeout( getProgress( id, feedToken, intervalTime ), intervalTime );
                } 
        },
        error : function(jqXHR, textStatus, errorThrown) {
                console.log(textStatus, errorThrown);
        }
    });
}

function getReport( id, feedToken, nfromLine, intervalTime ) {
    $.ajax({
        url: 'servlet/progressManager/progressFeed?report&fromLine=' + nfromLine + '&token=' + feedToken ,
        method: 'POST',
        async: true,
        success: function(data) {
                updateProgressReport( id, data.result, true );
                if ( getProgressValue( id ) < getProgressMaxValue( id ) ) {
                    setTimeout( getReport( id, feedToken, parseInt( $('#'+id+"-report").attr( "lastline" ) ), intervalTime ), intervalTime );
                } 
        },
        error : function(jqXHR, textStatus, errorThrown) {
                console.log(textStatus, errorThrown);
        }
    });
}

function updateProgressBar(id, percentage){
    $('#'+id).attr('value', percentage);
    $('#'+id).html( percentage+' /'+ getProgressMaxValue( id ) );
}

function updateProgressReport(id, report, isAppend) {
    if ( !isAppend ) {
        $('#'+id+"-report").html( report.lines.join("<br />") );
    } else {
        $('#'+id+"-report").append( report.lines.join("<br />") );
        $('#'+id+"-report").attr( "lastline" , report.lastLine );
    }
}

function getProgressMaxValue( id ){
	 return parseInt($('#'+id).attr('max'));
}

function getProgressValue( id ){
	 return parseInt($('#'+id).attr('value'));
}

function processError( id, errorMsg ) {
    updateProgressReport( id, errorMsg, true );
}


$(document).ready( function( ) {
    $('.progressmanager').each( function() {
            var id = $( this ).attr( "id" );
            var token = $( this ).attr( "token" );
            var showReport = $( this ).attr( "showReport" );
            var intervalTime = $( this ).attr( "intervalTime" );
            
            // get progress
            getProgress( id, token, intervalTime );
            
            if ( showReport ) {
                getReport( id, token, 0, intervalTime );
            }
    });
        
});    
