import { useEffect, useState } from "react";
import { retrieveNodeApi } from "./api/MapApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate, useParams, Link} from "react-router-dom";

function NodeComponent() {

    const {nodeId} = useParams()
    const [rootNode, setRootNode] = useState([])
    const [nodes, setNodes] = useState([])

    useEffect (() => refreshNode(), [])

    function refreshNode() {
        retrieveNodeApi(nodeId)
        .then(response => {
            setRootNode(response.data)
            setNodes(response.data.childNodes)
        })
        .catch(error => console.log(error))
    }

    const renderNodes = (inputNodes) => {
        return inputNodes.map((child, index) => (
            <div>
                <Link
                    key={child.id}
                    className="p-2 text-decoration-none"
                    to={`/nodes/${child.id}`}
                >
                    {child.name}
                </Link>
                {renderNodes(child.childNodes)}
            </div>
        ));
      };

    return (
        <div className="container">
            <h1>{rootNode.name}</h1>
            <div className="d-flex flex-row">
                {renderNodes(nodes)}
            </div>
      </div>
    )
}

export default NodeComponent