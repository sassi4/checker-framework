package checkers.flow.util;

import checkers.flow.cfg.node.ConditionalOrNode;
import checkers.flow.cfg.node.Node;
import checkers.util.TypesUtils;

import com.sun.source.tree.Tree;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree;

/**
 * A utility class to operate on a given {@link Node}.
 * 
 * @author Stefan Heule
 * 
 */
public class NodeUtils {

    /**
     * @return true iff <code>node</code> corresponds to a boolean typed
     *         expression (either the primitive type <code>boolean</code>, or
     *         class type {@link java.lang.Boolean})
     */
    public static boolean isBooleanTypeNode(Node node) {

        if (node instanceof ConditionalOrNode) {
            return true;
        }

        // not all nodes have an associated tree, but those are all not of a
        // boolean type.
        Tree tree = node.getTree();
        if (tree == null) {
            return false;
        }

        Type type = ((JCTree) tree).type;
        if (TypesUtils.isBooleanType(type)) {
            return true;
        }

        return false;
    }
}
