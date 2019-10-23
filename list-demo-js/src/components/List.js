import React from 'react';
import ListItem from "./ListItem";

class List extends React.Component {

    render() {
        return this.props.items.map((item) =>
            <ListItem key={item.id} category={item.category}/>
        );
    }
}

export default List;