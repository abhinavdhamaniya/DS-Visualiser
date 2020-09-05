function __getIEVersion() {
    var rv = -1; // Return value assumes failure.
    if (navigator.appName == 'Microsoft Internet Explorer') {
        var ua = navigator.userAgent;
        var re = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
        if (re.exec(ua) != null)
            rv = parseFloat(RegExp.$1);
    }
    return rv;
}

function __getOperaVersion() {
    var rv = 0; // Default value
    if (window.opera) {
        var sver = window.opera.version();
        rv = parseFloat(sver);
    }
    return rv;
}

var __userAgent = navigator.userAgent;
var __isIE =  navigator.appVersion.match(/MSIE/) != null;
var __IEVersion = __getIEVersion();
var __isIENew = __isIE && __IEVersion >= 8;
var __isIEOld = __isIE && !__isIENew;

var __isFireFox = __userAgent.match(/firefox/i) != null;
var __isFireFoxOld = __isFireFox && ((__userAgent.match(/firefox\/2./i) != null) || 
	(__userAgent.match(/firefox\/1./i) != null));
var __isFireFoxNew = __isFireFox && !__isFireFoxOld;

var __isWebKit =  navigator.appVersion.match(/WebKit/) != null;
var __isChrome =  navigator.appVersion.match(/Chrome/) != null;
var __isOpera =  window.opera != null;
var __operaVersion = __getOperaVersion();
var __isOperaOld = __isOpera && (__operaVersion < 10);

function __parseBorderWidth(width) {
    var res = 0;
    if (typeof(width) == "string" && width != null && width != "" ) {
        var p = width.indexOf("px");
        if (p >= 0) {
            res = parseInt(width.substring(0, p));
        }
        else {
     		//do not know how to calculate other values 
		//(such as 0.5em or 0.1cm) correctly now
    		//so just set the width to 1 pixel
            res = 1; 
        }
    }
    return res;
}

//returns border width for some element
function __getBorderWidth(element) {
	var res = new Object();
	res.left = 0; res.top = 0; res.right = 0; res.bottom = 0;
	if (window.getComputedStyle) {
		//for Firefox
		var elStyle = window.getComputedStyle(element, null);
		res.left = parseInt(elStyle.borderLeftWidth.slice(0, -2));  
		res.top = parseInt(elStyle.borderTopWidth.slice(0, -2));  
		res.right = parseInt(elStyle.borderRightWidth.slice(0, -2));  
		res.bottom = parseInt(elStyle.borderBottomWidth.slice(0, -2));  
	}
	else {
		//for other browsers
		res.left = __parseBorderWidth(element.style.borderLeftWidth);
		res.top = __parseBorderWidth(element.style.borderTopWidth);
		res.right = __parseBorderWidth(element.style.borderRightWidth);
		res.bottom = __parseBorderWidth(element.style.borderBottomWidth);
	}
   
	return res;
}

//returns the absolute position of some element within document
function getElementAbsolutePos(element) {
	var res = new Object();
	res.x = 0; res.y = 0;
	if (element !== null) 
	{ 
		if (element.getBoundingClientRect) 
		{
			var viewportElement = document.documentElement;  
 	        var box = element.getBoundingClientRect();
		    var scrollLeft = viewportElement.scrollLeft;
 		    var scrollTop = viewportElement.scrollTop;

		    res.x = box.left + scrollLeft;
		    res.y = box.top + scrollTop;
		}
		
	}
	
    return res;
}

function rearrangeNodes(maxID)
{

	if(maxID==-1) return;
	
	//setting svg height
	var svgobj= document.getElementsByTagName("svg")[0];
	var height= parseInt(document.getElementById("height").innerHTML);
	svgobj.setAttribute("height", 200*height);
	
	//setting svg width
	//var width= parseInt(document.getElementById("width").innerHTML);
	//svgobj.setAttribute("width", 200*width);
	
	var nodeCount= parseFloat(maxID);
	//centering the rootnode
	rootNode= document.getElementById("1");
	rootNode.style.position = "absolute";
    rootNode.style.left = (745)+'px';
    rootNode.style.top = (250)+'px';
	
	
	//positioning all the other nodes
	var childdata= document.getElementById("child-data").innerHTML;
	var levelNodes= document.getElementById("levelNodes").innerHTML;
	
	var childArr= childdata.split(",");
	var levelArr= levelNodes.split(",");
	
	var iterator = childArr.values();
	var iterator2= levelArr.values();
	var curr= iterator2.next().value;
	
	var offset=0;
	
	var set = new Set(); 
	
	var c=0;
	for (let elements of iterator) 
	{ 
		var innerdata= elements.split(" ");
	
		if(innerdata[0]==undefined) continue;
		if(innerdata[1]==undefined) continue;
		if(innerdata[2]==undefined) continue;
		
		var childID= innerdata[0].trim();
		var parID= innerdata[1].trim();
		var type= innerdata[2].trim();
		
		if(childID!=undefined && parID!=undefined && type!=undefined)
		{
			var parent= document.getElementById(parID);
			var parentPos = getElementAbsolutePos(parent);
			var child = document.getElementById(childID);
			
			if(type=='L')
			{
			    child.style.position = "absolute";
			    child.style.left = (parentPos.x-120+offset)+'px';
			    child.style.top = (parentPos.y+120)+'px';	
			}
			else
			{
				child.style.position = "absolute";
			    child.style.left = (parentPos.x+120-offset)+'px';
			    child.style.top = (parentPos.y+120)+'px';
			}
		}
		c++;
		if(c==curr)
		{
			if(offset<=100) offset+=20;
			c=0;
			curr= iterator2.next().value;
		}	
	}
	
	//Drawing edges between nodes
	var parentdata= document.getElementById("parent-data").innerHTML;
	var parentArr= parentdata.split(",");
	var iterator3 = parentArr.values();
	
	for (let elements of iterator3) 
	{ 
		var innerdata= elements.split(" ");
	
		if(innerdata[0]==undefined) continue;
		if(innerdata[1]==undefined) continue;
		if(innerdata[2]==undefined) continue;
		
		var parentID= innerdata[0].trim();
		var LChildID= innerdata[1].trim();
		var RChildID= innerdata[2].trim();
		
		var parent= document.getElementById(parentID);
		var LChild = document.getElementById(LChildID);
		var RChild = document.getElementById(RChildID);
		
		var parentPos = getElementAbsolutePos(parent);
		var LCPos = getElementAbsolutePos(LChild);
		var RCPos = getElementAbsolutePos(RChild);
		//window.alert(parent.innerHTML);
		if(LChildID!=-1)
		{
			var newLine = document.createElementNS('http://www.w3.org/2000/svg','line');
			newLine.setAttribute('id','line2');
			newLine.setAttribute('x1',parentPos.x+22);
			newLine.setAttribute('y1',parentPos.y-150);
			newLine.setAttribute('x2',LCPos.x+22);
			newLine.setAttribute('y2',LCPos.y-150);
			newLine.setAttribute("stroke", "black")
			
			var svgele = document.getElementById('svgid');
			svgele.append(newLine);
		}
		if(RChildID!=-1)
		{
			var newLine = document.createElementNS('http://www.w3.org/2000/svg','line');
			newLine.setAttribute('id','line2');
			newLine.setAttribute('x1',parentPos.x+20);
			newLine.setAttribute('y1',parentPos.y-150);
			newLine.setAttribute('x2',RCPos.x+20);
			newLine.setAttribute('y2',RCPos.y-150);
			newLine.setAttribute("stroke", "black")
			
			var svgele = document.getElementById('svgid');
			svgele.append(newLine);
		}
	}
}

