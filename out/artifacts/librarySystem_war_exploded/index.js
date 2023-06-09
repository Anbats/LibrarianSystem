function onDrag(e){
	    const container=document.querySelector(".container")
	    let oddStyle=window.getComputedStyle(container)
	    let left=parseFloat(oddStyle.left)
	    let top=parseFloat(oddStyle.top)
	    container.style.left=`${left+e.movementX}px`
	    container.style.top=`${top+e.movementY}px`
	}
	const dragElement=document.querySelector(".drag-bar")
	dragElement.addEventListener("mousedown",()=>{
	    document.addEventListener("mousemove",onDrag)
	    document.addEventListener("mouseup",()=>{
	        document.removeEventListener("mousemove",onDrag)
	    })
	})
	function openDialog1(){
            document.getElementById('light1').style.display='block';
        }
    function closeDialog1(){
            document.getElementById('light1').style.display='none';
        }
    function openDialog2(){
            document.getElementById('light2').style.display='block';
        }
    function closeDialog2(){
            document.getElementById('light2').style.display='none';
        }
    function openDialog3(){
            document.getElementById('light3').style.display='block';
        }
    function closeDialog3(){
            document.getElementById('light3').style.display='none';
        }
    function openDialog4(){
            document.getElementById('light4').style.display='block';
        }
    function closeDialog4(){
            document.getElementById('light4').style.display='none';
        }
    function openDialog(){
            document.getElementById('light').style.display='block';
        }
    function closeDialog(){
            document.getElementById('light').style.display='none';
        }
function onclickFun(){

}