import React from 'react';

class ListItem extends React.Component {

    render() {
        return (
            <ul style={ rowStyle }>{ this.props.category }</ul>
        )
    }
}

const rowStyle = {
    backgroundColor: '#EFEFEF',
    padding: '10px',
    borderBottom: '1px #BBB dotted'
};

export default ListItem;