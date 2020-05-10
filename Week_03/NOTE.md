# 学习笔记

## 递归  
* Java递归代码模板  
```Java
public void recur(int level, int param) { 
  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 
  process(level, param); 
  // drill down 
  recur( level: level + 1, newParam); 
  // restore current status 
 
}
```

* 应用场景 具有相似重复性的问题的解决，如二叉树相关的问题等。


## 分治  
* Java分治代码模板  
```Java
public void divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 
  if (problem == null){
    //print_result 
    return;
  }

  # prepare data 
  data = prepare_data(problem);
  subproblems = split_problem(problem, data); 

  # conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...); 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...); 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...); 
  …

  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …);
	
  # revert the current level states
```

* 是一种特殊的递归，相对递归，分治将一个大问题拆分成若干小问题进行处理，再逐步将小问题的解答进行合并，从而达到解决大问题的效果。能够有效的提高解决问题的效率。

## 回溯  
* 个人理解 回溯就是一种特殊的递归，通过不断的修改参数，尝试所有的情况来找到答案。所以相比递归，回溯会多出来一步修改参数的操作。
* 适用场景 如找所有子集，排列组合等类似问题。
