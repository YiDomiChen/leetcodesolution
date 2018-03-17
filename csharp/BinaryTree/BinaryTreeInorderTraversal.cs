using System;
using System.Collections;
using System.Collections.Generic;


namespace BinaryTree
{
    public class BinaryTreeInorderTraversal
    {
        public IList<int> InorderTraversal(TreeNode root)
        {
            IList<int> res = new List<int>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.Push(root);
            while (stack.Count != 0)
            {
                TreeNode cur = stack.Pop();
                res.Add(cur.val);
                if (cur.right != null)
                {
                    stack.Push(cur.right);
                }
                if (cur.left != null)
                {
                    stack.Push(cur.left);
                }
            }

            return res;
        }

        public void test()
        {
            TreeNode root = new TreeNode(1);
            TreeNode left = new TreeNode(2);
            root.left = left;
            TreeNode right = new TreeNode(3);
            root.right = right;

            left.left = new TreeNode(4);
            right.left = new TreeNode(5);
            right.right = new TreeNode(6);

            IList<int> res = InorderTraversal(root);
            foreach (int v in res)
            {
                Console.Write(v.ToString() + ", ");
            }
        }
    }
}
