	var boxCenterXOffset = 18;
	var boxCenterYOffset = 18;
	var linecount=1;

	var adjMatrix;
	var n=0;

	var highestDegreeNodeID=-1;

	function parseMatrix()
	{
		
		document.getElementById('nodes').innerHTML = '';
		document.getElementById('lines').innerHTML = '';
		boxCenterXOffset = 18;
		boxCenterYOffset = 24;
		linecount=1;

		var adjMatrix;
		n=0;
	

		var matData= document.getElementById("matrix").value;
		var rows= matData.split(/\r?\n/);

		n= rows[0].split(",").length;

		adjMatrix= new Array(rows.length);

		for (var i=0; i<n; i++) 
		{ 
			adjMatrix[i] = rows[i].split(","); 
		}	
		
		//finding node with highest degree 
		var maxc=-1;
		var maxID=-1;
		for (var i=0; i<n; i++) 
		{ 
			var count=0;
			for (var j=0; j<n; j++) 
			{ 
				if(adjMatrix[i][j]=="1") count++;
			}	
			if(count>maxc)
			{
				maxc= count;
				maxID= i+1;	
			}
		}	

		highestDegreeNodeID=maxID;
		

		for(var i=1; i<=n; i++)
		{
			if(adjMatrix[i-1][i-1]==1)
			{
				$("#nodes").append(`<div id='box${i}' class='box ui-draggable'><div class='arc'></div>${i-1}</div>`);
			}
			else
			{
				$("#nodes").append(`<div id='box${i}' class='box ui-draggable'>${i-1}</div>`);
			}
		}

		$(document).ready(function()
		{
				
				//spawning all edges
				for(var i=1; i<=n; i++)
				{
					for(var j=1; j<=n; j++)
					{
						$("#lines").append(`<p id='line${i}${j}' class='lineclass'></p>`);
					}
				}
				
				
				$(".box").draggable({ delay: 0, distance: 0 },
				{	
					
					drag: function(event, ui)
					{
						
						for(var i=1; i<=n; i++)
						{
							for(var j=1; j<=n; j++)
							{
								
								if(adjMatrix[i-1][j-1]==1)
								{
									var x1 = $("#box"+ i).offset().left + boxCenterXOffset;
									var x2 = $("#box"+ j).offset().left + boxCenterXOffset;
									var y1 = $("#box"+ i).offset().top + boxCenterYOffset;
									var y2 = $("#box"+ j).offset().top + boxCenterYOffset;
									
									if(i!=j)
									{
										//draw edge (line)
										var hypotenuse = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
										var angle = Math.atan2((y1-y2), (x1-x2)) *  (180/Math.PI);

										if(angle >= 90 && angle < 180){
											y1 = y1 - (y1-y2);
										}
										if(angle > 0 && angle < 90){
											x1 = x1 - (x1-x2);
											y1 = y1 - (y1-y2);
										}
										if(angle <= 0 && angle > -90){
											x1 = x1 - (x1-x2);
										}
										
										$("#line"+i+j).queue(function(){
											$(this).offset({top: y1, left: x1});
											$(this).dequeue();
										}).queue(function(){
											$(this).width(hypotenuse);
											$(this).dequeue();
										}).queue(function(){
											$(this).rotate(angle);
											$(this).dequeue();
										});
									}
								}					
							}
						}
						
				}
			});
		});
		
		//radomizing the nodes' positions
		randomizeNodes(n, highestDegreeNodeID);

		//stimulating initial drag
		$(".box").simulate('drag');
	}

function checkPosAvailability(arr, posObj)
{
	var x= parseFloat(posObj.x);
	var y= parseFloat(posObj.y);
	var n= parseInt(arr.length);
	
	if(x<15 || x>window.innerWidth-25)  return false;
	
	for(var i=0; i<n; i++)
	{
		if(x>=parseFloat(arr[i].x) && x<=parseFloat(arr[i].x)+60)
		{
			return false;
		}
		if(x<=parseFloat(arr[i].x) && x>=parseFloat(arr[i].x)-60)
		{
			return false;
		}
	}

	return true;
}

function randomizeNodes(num, midNodeID)
{
	
	var graphdiv = document.getElementById("nodes");
	var xmid= graphdiv.offsetWidth/2;
	var ymid= graphdiv.offsetWidth/2;
	
	
	var midNode= document.getElementById("box"+midNodeID);
	midNode.style.left = xmid+"px";
	midNode.style.top = ymid+"px";

	var pos={
		"x": xmid,
		"y": ymid
	};

	var postitionsTaken= [];
	postitionsTaken.push(pos);

	for(var i=1; i<=n; i++)
	{
		if(i!=midNodeID)
		{
			
			do
			{
				//get a random angle
				var angle = Math.random()*Math.PI*2;
				
				var radius=Math.random()*220*(n*0.2);

				x = Math.cos(angle)*radius+xmid;
				y = Math.sin(angle)*radius+ymid;

				var npos={
					"x": x,
					"y": y
				};
				
				//alert(checkPosAvailability(postitionsTaken, pos));

			} while(checkPosAvailability(postitionsTaken, npos)==false);

			postitionsTaken.push(npos);
			document.getElementById("box"+i).style.left=x+"px";
			document.getElementById("box"+i).style.top=y+"px";

			
		}
	}

}
