$(document).ready(function(){
  $("#upload").click(function(){
	 $("#myFile").trigger("click");
	 $("#myFile").change(function(){
		   $.ajaxFileUpload({
	            url: 'uploadAction', 
	            type: 'post',
	            secureuri: false, //һ������Ϊfalse
	            fileElementId: 'myFile', // �ϴ��ļ���id��name������
	            dataType: 'text', //����ֵ���ͣ�һ������Ϊjson��application/json
	            success : function(data) {  
	         if(data!=0){
	            $("#headimg").html("<img width='100px' height='100px' src = 'upload/"+data+"'/>");
	            $("#imgsrc").val(data);
	           }else{
	            alert('�ϴ���ͷ�񲻷��ϸ�ʽҪ����ʹ�ñ�׼����༭��ͼƬ');
	           } 
	         }
	        }); 
	 });

  });
 });