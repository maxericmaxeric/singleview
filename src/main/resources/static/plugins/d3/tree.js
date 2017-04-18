function BuildVerticaLTree(treeData, treeContainerDom, w, h) {
	var margin = { top: 40, right: 50, bottom: 20, left: 50 };
	var width = w - margin.right - margin.left;
	var height = h - margin.top - margin.bottom;

	var i = 0, duration = 750;
	var tree = d3.layout.tree()
		.size([width, height])
		.separation(function(a, b) { return (a.parent == b.parent ? 20 : 20); });
	var diagonal = d3.svg.diagonal()
		.projection(function (d) { return [d.x, d.y]; });
	var svg = d3.select(treeContainerDom).append("svg")
		.attr("width", width + margin.right + margin.left)
		.attr("height", height + margin.top + margin.bottom)
		.append("g")
		.attr("transform", "translate(" + margin.left + "," + margin.top + ")");
	root = treeData;

	update(root);
	
	function update(source) {
		// Compute the new tree layout.
		var nodes = tree.nodes(root).reverse(),
			links = tree.links(nodes);
		// Normalize for fixed-depth.
		nodes.forEach(function (d) { d.y = d.depth * 120;});
		// Declare the nodes��
		var node = svg.selectAll("g.node")
			.data(nodes, function (d) { return d.id || (d.id = ++i); });
		// Enter the nodes.
		var nodeEnter = node.enter().append("g")
			.attr("class", "node")
			.attr("transform", function (d) {
				return "translate(" + source.x0 + "," + source.y0 + ")";
			});
			//.on("click", nodeclick);
		nodeEnter.append("circle")
			.attr("r", 10)
			.attr("stroke", function (d) { return d.children || d._children ? "steelblue" : "#00c13f"; })
			.style("fill", function (d) { return d.children || d._children ? "lightsteelblue" : "#fff"; });
		//.attr("r", 10)
		//.style("fill", "#fff");
		nodeEnter.append("text")
			.attr("y", function (d) {
				return d.children || d._children ? -18 : 18;
			})
			.attr("dy", ".35em")
			.attr("text-anchor", "middle")
			.text(function (d) { return d.prtynm; })
			.style("fill-opacity", 1e-6);
		// Transition nodes to their new position.
		//horizontal tree
		var nodeUpdate = node.transition()
			.duration(duration)
			.attr("transform", function (d) { return "translate(" + d.x + "," + d.y + ")"; });
		nodeUpdate.select("circle")
			.attr("r", 10)
			.style("fill", function (d) { return d._children ? "lightsteelblue" : "#fff"; });
		nodeUpdate.select("text")
			.style("fill-opacity", 1);


		// Transition exiting nodes to the parent's new position.
		var nodeExit = node.exit().transition()
			.duration(duration)
			.attr("transform", function (d) { return "translate(" + source.x + "," + source.y + ")"; })
			.remove();
		nodeExit.select("circle")
			.attr("r", 1e-6);
		nodeExit.select("text")
			.style("fill-opacity", 1e-6);
		// Update the links��
		// Declare the links��
		var link = svg.selectAll("path.link")
			.data(links, function (d) { return d.target.id; });
		// Enter the links.
		link.enter().insert("path", "g")
			.attr("class", "link")

			.attr("d", function (d) {
				var o = { x: source.x0, y: source.y0 };
				return diagonal({ source: o, target: o });
			});
		// Transition links to their new position.
		link.transition()
			.duration(duration)
			.attr("d", diagonal);
		/*	
		// Transition exiting nodes to the parent's new position.
		link.exit().transition()
			.duration(duration)
			.attr("d", function (d) {
				var o = { x: source.x, y: source.y };
				return diagonal({ source: o, target: o });
			})
			.remove();

		// Stash the old positions for transition.
		nodes.forEach(function (d) {
			d.x0 = d.x;
			d.y0 = d.y;
		});*/
	}

	// Toggle children on click.
	/*function nodeclick(d) {
		if (d.children) {
			d._children = d.children;
			d.children = null;
		} else {
			d.children = d._children;
			d._children = null;
		}
		update(d);
	}*/
}

function BuildVerticaLTree2(treeData, treeContainerDom, w, h, showDiv) {
	var margin = { top: 40, right: 50, bottom: 20, left: 50 };
	var width = w - margin.right - margin.left;
	var height = h - margin.top - margin.bottom;

	var i = 0, duration = 750;
	var tree = d3.layout.tree()
		.size([width, height])
		.separation(function(a, b) { return (a.parent == b.parent ? 20 : 20); });
	var diagonal = d3.svg.diagonal()
		.projection(function (d) { return [d.x, d.y]; });
	var svg = d3.select(treeContainerDom).append("svg")
		.attr("width", width + margin.right + margin.left)
		.attr("height", height + margin.top + margin.bottom)
		.append("g")
		.attr("transform", "translate(" + margin.left + "," + margin.top + ")");
	root = treeData;

	update(root);
	
	function update(source) {
		// Compute the new tree layout.
		var nodes = tree.nodes(root).reverse(),
			links = tree.links(nodes);
		// Normalize for fixed-depth.
		nodes.forEach(function (d) { d.y = d.depth * 120; });
		// Declare the nodes��
		var node = svg.selectAll("g.node")
			.data(nodes, function (d) { return d.id || (d.id = ++i); });
		// Enter the nodes.
		var nodeEnter = node.enter().append("g")
			.attr("class", "node")
			.attr("transform", function (d) {
				return "translate(" + source.x0 + "," + source.y0 + ")";
			}).on("mouseover", node_mouseover).on("mouseout", node_mouseout);
		nodeEnter.append("circle")
			.attr("r", 10)
			.attr("stroke", function (d) { return d.children || d._children ? "steelblue" : "#00c13f"; })
			.style("fill", function (d) { return d.children || d._children ? "lightsteelblue" : "#fff"; });
		//.attr("r", 10)
		//.style("fill", "#fff");
		nodeEnter.append("text")
			.attr("y", function (d) {
				return d.children || d._children ? -18 : 18;
			})
			.attr("dy", ".35em")
			.attr("text-anchor", "middle")
			.text(function (d) { return d.display; })
			.style("fill-opacity", 1e-6);
		// Transition nodes to their new position.
		//horizontal tree
		var nodeUpdate = node.transition()
			.duration(duration)
			.attr("transform", function (d) { return "translate(" + d.x + "," + d.y + ")"; });
		nodeUpdate.select("circle")
			.attr("r", 10)
			.style("fill", function (d) { return d._children ? "lightsteelblue" : "#fff"; });
		nodeUpdate.select("text")
			.style("fill-opacity", 1);


		// Transition exiting nodes to the parent's new position.
		var nodeExit = node.exit().transition()
			.duration(duration)
			.attr("transform", function (d) { return "translate(" + source.x + "," + source.y + ")"; })
			.remove();
		nodeExit.select("circle")
			.attr("r", 1e-6);
		nodeExit.select("text")
			.style("fill-opacity", 1e-6);
		// Update the links��
		// Declare the links��
		var link = svg.selectAll("path.link")
			.data(links, function (d) { return d.target.id; });
		// Enter the links.
		link.enter().insert("path", "g")
			.attr("class", "link")

			.attr("d", function (d) {
				var o = { x: source.x0, y: source.y0 };
				return diagonal({ source: o, target: o });
			});
		// Transition links to their new position.
		link.transition()
			.duration(duration)
			.attr("d", diagonal);
	
		function node_mouseover(d){
			if (d.parentid != "0"){
				var objDiv = $(showDiv); 
				$(objDiv).css("display","block"); 
				$(objDiv).find("small").eq(0).html("&nbsp;&nbsp;line name : "+d.name1+"&nbsp;&nbsp;");
				$(objDiv).find("small").eq(1).html("&nbsp;&nbsp;currency : "+d.currency+"&nbsp;&nbsp;");
				$(objDiv).find("small").eq(2).html("&nbsp;&nbsp;available amount : "+d.available_Amount+"&nbsp;&nbsp;");
				$(objDiv).css("left", d.x - 10); 
				$(objDiv).css("top", d.y); 
			}
		}
		
		function node_mouseout(d){
			if (d.parentid != "0"){
				var objDiv = $(showDiv); 
				$(objDiv).css("display","none");
			}
		}
	}
}

function transData(data, idStr, pidStr, chindrenStr){    
    var r = [], hash = {}, id = idStr, pid = pidStr, children = chindrenStr;    
    for(var i = 0; i < data.length; i++){    
        hash[data[i][id]] = data[i];    
    }    
    for(var j = 0; j < data.length; j++){    
        var aVal = data[j], hashVP = hash[aVal[pid]]; 
        if(hashVP){    
            !hashVP[children] && (hashVP[children] = []);    
            hashVP[children].push(aVal);    
        }else{    
            r.push(aVal);    
        }    
    }    
    return r;    
} 

