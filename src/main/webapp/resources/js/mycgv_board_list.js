$(document).ready(function(){

	initAjax(1);

	function initAjax(page){
		$.ajax({
			url: "board_list_json_data.do?page="+page,
			success : function (result){
				alert(result); //문자
				let jdata = JSON.parse(result);
				//alert(jdata); //json 객체
				
				//dhtml을 활용하여 테이블로 출력 
				let output = "<table class='board_list'>";
				output += "<tr>";
				output += "<td colspan='5'>";
				output += "<a href='board_write.do'>";
				output += "<button type='button' class='btn_style2' id='btnBoardWrite'>글쓰기</button>";
				output += "</a>";
				output += "</td>";
				output += "</tr>";
				output += "<tr>";
				output += "<th>번호</th>";
				output += "<th>제목</th>";
				output += "<th>조회수</th>";
				output += "<th>작성자</th>";
				output += "<th>작성일자</th>";
				for(obj of jdata.jlist){
				output += "</tr>";
				output += "<tr>";
				output += "<td>"+ obj.rno+"</td>";
				output += "<td>"+ obj.btitle+"</td>";
				output += "<td>"+ obj.bhits+"</td>";
				output += "<td>"+ obj.id+"</td>";
				output += "<td>"+ obj.bdate+"</td>";
				output += "</tr>";
				}
				output += "<tr>";
				output += "<td colspan='5'><div id='ampaginationsm'></div></td>";
				output += "</tr>";
				output += "</table>";
				
				//output을 출력
				
				$("table.board_list").remove();
				$("h1").after(output);
				
				//페이지 처리 함수 호출
				pager(jdata.totals, jdata.maxSize, jdata.pageSize, jdata.page);
				
				//페이지 번호 클릭 호출
				jQuery('#ampaginationsm').on('am.pagination.change',function(e){
					   jQuery('.showlabelsm').text('The selected page no: '+e.page);
			           //$(location).attr('href', "http://localhost:9000/mycgv_jsp/board_list_json.do?page="+e.page);       
			    initAjax(e.page);
			    });
			    
				
				
			} //success
			
		}); //ajax
	} //initAjax
	
	/* 페이징 처리 함수 */
	function pager(totals, maxSize, pageSize, page) {
		var pager = jQuery('#ampaginationsm').pagination({
		
		    maxSize: maxSize,	    		// max page size
		    totals: totals,	// total pages	
		    page: page,		// initial page 현제 페이지 reqpage
		    pageSize: pageSize,			// max number items per page
		
		    // custom labels		
		    lastText: '&raquo;&raquo;', 		
		    firstText: '&laquo;&laquo;',		
		    prevText: '&laquo;',		
		    nextText: '&raquo;',
				     
		    btnSize:'sm'	// 'sm'  or 'lg'		
		});
		
		
	}







}); //ready